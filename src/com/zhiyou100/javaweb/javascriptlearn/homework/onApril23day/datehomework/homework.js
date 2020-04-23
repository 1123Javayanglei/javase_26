function myRandom(min, max) {
    // TODO 生成 [min,max]的随机数,包含min和max的值
    return parseInt(min + (Math.random() * (max - min + 1)));
}

function judgeTheDaysOfTheMonth(year, month) {
    /*
     * @name: judgeTheDaysOfTheMonth
     * @param: int year ,int month
     * @description: TODO  判断本月有多少天
     * @date: 2020/2/21 5:00 下午
     * @return: int
     */
    let yearLag = (((year % 4 === 0) && (year % 100 !== 0)) || (year % 400 === 0));
    // yearLag true为闰年，false为平年
    /*
     * 平年的2月份是28天
     * 闰年的2月份是29天
     */
    let maxDay = 0;
    switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            maxDay = 31;
            break;
        case 2:
            if (yearLag) {
                maxDay = 29;
            } else {
                maxDay = 28;
            }
            break;
        default:
            maxDay = 30;
    }
    return maxDay;
}

function addZero(num) {
    /*
     * @name: addZero
     * @param: int num
     * @description: TODO  把 1 变成 01
     * @date: 2020/2/21 5:43 下午
     * @return: String
     */
    return num < 10 ? "0" + num.toString() : num;
}

function getIntoStringOutDate(s) {
    // TODO 写一个方法获取参数字符串表示的时间 距离过年还有多少天：字符串格式：1900-11-12
    if (typeof s != "string" || s.length < 10 || s.indexOf("-") === -1) {
        // 判断格式是否合法
        return;
    }

    // 提取参数字符的年月日
    let intoYear = parseInt(s.substring(0, 4));
    let intoMonth = parseInt(s.substring(5, 7));
    let intoDay = parseInt(s.substring(8, 10));

    let intoDate = new Date(intoYear, intoMonth - 1, intoDay);
    // 从参数字符串获取一个日期
    // 注意 0 = 1月 ， 1 = 2月
    let nextDate = new Date(intoYear + 1, 0, 1);
    let passBy = intoDate.getTime();
    let future = nextDate.getTime();
    // 1 天 等於 86,400,000 ms
    return (future - passBy) / (24 * 60 * 60 * 1000);
}


function randomTheDate() {
    // TODO 写一个方法  随机一个日期时间：xxxx-xx-xx xx:xx:xx   年在1000-2000年之间
    let randomOfYear = myRandom(1000, 2000);
    // 年[1000,2000]
    let randomOfMonth = myRandom(1, 12);
    // 月 [1,12]
    let randomOfDay = myRandom(1, judgeTheDaysOfTheMonth(randomOfYear, randomOfMonth));
    // 天 [1,本月的天数]
    let randomHours = myRandom(0, 23);
    // 小时 [0,23]
    let randomMinute = myRandom(0, 59);
    // 分钟 [0,59]
    let randomSecond = myRandom(0, 59);
    // 秒 [0,59]

    return addZero(randomOfYear) + "-" + addZero(randomOfMonth) + "-" + addZero(randomOfDay)
        + " " + addZero(randomHours) + ":" + addZero(randomMinute) + ":" + addZero(randomSecond);
}

function returnsTheNumberOfDigitsOfANumber(number) {
    // TODO 判断一个整数的位数
    if (typeof number != "number") {
        return;
    }
    let flag = 0;
    while (parseInt(number) > 0) {
        // js中，能算到小数位置，必须转换为整数
        number /= 10;
        flag += 1;
    }
    return flag;
}

function printArray1(array) {
    // TODO 打印参数整数数组
    for (let i = 0; i < array.length; i++) {
        for (let j = 1; j <= array[i]; j++) {
            document.write("*");
        }
        document.write("<br>");
    }
}

function printArray2(array) {
    // TODO 打印参数整数数组：
    let max = array.slice().sort().pop();
    // 找到最大值
    document.write("<table>");
    for (let i = 1; i <= max; i++) {
        document.write("<tr>");
        for (let j = 0; j <array.length ; j++) {
            if (i<=max-array[j]){
                document.write("<td></td>");
            }else {
                document.write("<td>*</td>");
            }
        }
    }
}

