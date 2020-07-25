var chairJs = {
    setChairStatus: function () {
        var morning = $('#morning');
        var afternoon = $('#afternoon');
        var night = $('#night');
        var allDay = $('#allDay');
        var today = new Date();
        var hours = today.getHours();
        /**
         * 上午：06:00~12:00
         * 下午：12:00~18;00
         * 晚上：18;00~21:10
         * 整天：06:00~21:10
         * 其实所有选中座位都是永久可变的，使用@Schedule注解后将时间分割为一天、上午、下午、晚上四个状态。
         */
        // 非工作时间
        if (hours < 6) {
            alert('非工作时间，请6点过后访问');
            morning.css('background', '#313335');
            morning.attr("href", "#");
            afternoon.css('background', '#313335');
            afternoon.attr("href", "#");
            night.css('background', '#313335');
            night.attr("href", "#");
            allDay.css('background', '#313335');
            allDay.attr("href", "#");
        } // 上午全天状态的都可以选择，所以直接从下午开始。下午：上午的无法再次选中
        else if ((hours >= 12 && hours < 18)) {
            morning.css('background', '#313335');
            morning.attr("href", "#");
        } // 晚上：上午、下午的无法再次选中
        else if ((hours >= 18 && hours < 21)) {
            morning.css('background', '#313335');
            morning.attr("href", "#");
            afternoon.css('background', '#313335');
            afternoon.attr("href", "#");
        }
    }
};




