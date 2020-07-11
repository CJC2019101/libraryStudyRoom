package cn.cqucc.library.es.bo;

import cn.cqucc.library.es.api.searchApi;
import cn.cqucc.library.model.school.resp.FindAllSchoolResp;
import cn.cqucc.library.service.school.dao.ISchoolDAO;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Cancellable;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author JianfeiChen
 * @date 2020/7/4 21:25
 * @Description cn.cqucc.library.es.bo
 */
@Service
public class SearchBO implements searchApi {

    @Autowired
    ISchoolDAO schoolDAO;
    @Autowired
    RestHighLevelClient client;

    @Override
    public void transferSQLDataToES() {
        List<FindAllSchoolResp> allSchool = schoolDAO.findAllSchool();
        BulkRequest request = new BulkRequest(); //创建BulkRequest
        for (FindAllSchoolResp schoolResp : allSchool) {
            request.add(
                    new IndexRequest("school")
                            .id(UUID.randomUUID().toString().replaceAll("-",""))
                            .source(XContentType.JSON,
                                    "school_name", schoolResp.getSchoolName(),
                                    "admin_account", schoolResp.getAdminAccount(),
                                    "school_code", schoolResp.getSchoolCode(),
                                    "school_location", schoolResp.getSchoolLocation(),
                                    "create_at", schoolResp.getCreateAt(),
                                    "update_at", schoolResp.getUpdateAt(),
                                    "is_valid", schoolResp.isValid()));
        }
        ActionListener<BulkResponse> listener = new ActionListener<BulkResponse>() {
            @Override
            public void onResponse(BulkResponse bulkResponse) {
                //成功的时候调用
                if (bulkResponse.hasFailures()) { // 如果至少有一个操作失败，此方法返回true
                    for (BulkItemResponse bulkItemResponse : bulkResponse) {
                        if (bulkItemResponse.isFailed()) { //指示给定操作是否失败
                            BulkItemResponse.Failure failure =
                                    bulkItemResponse.getFailure();
                            // 检索失败操作的失败
                            System.out.println("failure = " + failure.getMessage());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
                //出错的时候调用
                System.out.println("e.getMessage() = " + e.getMessage());
            }
        };
        // 异步执行执行的批量请求和执行完成时要使用的操作侦听器
        client.bulkAsync(request, RequestOptions.DEFAULT, listener);
    }


}
