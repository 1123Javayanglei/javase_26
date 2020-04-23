'use strict';

// 第一题
function printStart(start) {
    // TODO 打印标签起始标签
    if (typeof start != "string") {
        // 如果不是个字符串，抛出异常
        throw "not a string";
    }
    document.write("<" + start + ">");
}

function printEnd(end) {
    // TODO 打印结束标签
    if (typeof end != "string") {
        // 如果不是个字符串，抛出异常
        throw "not a string";
    }
    document.write("</" + end + ">");
}

function printH1Title(title) {
    // TODO 打印标题
    document.write("<h1>" + title + "</h1>");
}

function leftTopPrint() {
    // TODO 打印左上角
    printH1Title("第一个九九乘法");
    printStart("table");
    for (let i = 1; i < 10; i++) {
        printStart("tr");
        for (let j = i; j < 10; j++) {
            document.write("<td>" + i + "*" + j + "=" + (i * j) + "</td>");
        }
        printEnd("tr");
    }
    printEnd("table");
    printStart("br");
}

function leftBottomPint() {
    // TODO 打印左下角
    printH1Title("第二个九九乘法");
    printStart("table");
    for (let i = 1; i < 10; i++) {
        printStart("tr");
        for (let j = 1; j <= i; j++) {
            document.write("<td>" + i + "*" + j + "=" + (i * j) + "</td>");
        }
        printEnd("tr");
    }
    printEnd("table");
}

function rightTopPrint() {
    // TODO 打印右上角
    printH1Title("第三个九九乘法表");
    printStart("table");
    for (let i = 1; i < 10; i++) {
        printStart("tr");
        for (let j = 0; j < i; j++) {
            document.write("<td style='border: none;'></td>");
        }
        for (let j = i; j < 10; j++) {
            document.write("<td>" + i + "*" + j + "=" + (i * j) + "</td>");
        }
        printEnd("tr");
    }
    printEnd("table");
}

function rightBottomPrint() {
    // TODO 打印右下角
    printH1Title("第四个九九乘法表");
    printStart("table");
    for (let i = 1; i < 10; i++) {
        printStart("tr");
        for (let j = 1; j < (10 - i); j++) {
            document.write("<td style='border: none;'></td>");
        }
        for (let j = i; j > 0; j--) {
            document.write("<td>" + i + "*" + j + "=" + (i * j) + "</td>");
        }
        printEnd("tr");
    }
    printEnd("table");
}


// 第二题
function toDetermineWhetherANumberIsPrime(number) {
    // TODO 判断一个数是不是质数
    if (typeof number != "number") {
        // 如果不是number类型的，跳出
        return;
    }
    let flag = false;
    // 记录
    for (let i = 2; i <= Math.sqrt(number); i++) {
        if (number % i === 0) {
            // 在js中判断要用 ===，而不是 ==
            flag = true;
            break;
        }
    }
    if (flag || number <= 1) {
        // 不是质数
        return false;
    } else {
        // 是质数
        return true;
    }
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

function determinesWhetherTheNumberContains1(number) {
    // TODO 判断一个数字是否包含1
    if (typeof number != "number") {
        // 如果不是number类型，跳出
        return;
    }
    let temp = number.toString();
    // 转换为数字
    if ((temp.indexOf('1')) === -1) {
        // 如果返回-1，说明不包含1
        return false;
    } else {
        // 其他情况，包含1
        return true;
    }


}

function primeNumbersSum() {
    // TODO 获取1到100内所有位数上含有1的质数的和
    let sum = 0;
    for (let i = 1; i <= 100; i++) {
        if (toDetermineWhetherANumberIsPrime(i)) {
            // 是否是质数
            if (determinesWhetherTheNumberContains1(i)) {
                // 是否包含1
                sum += i;
            }
        }
    }
    return sum;
}

// 第三题

function MyPI() {
    // TODO  求圆周率到3.1415926-3.1415927之间需要的是运算步骤
    let cnt;
    let pi = 0;
    let piMin = 3.1415926;
    let piMax = 3.1415927;
    let sum = 0;
    for (cnt = 1; pi < piMin || pi > piMax; cnt++) {
        if (cnt % 2 === 0) {
            sum = -4.0 / (2 * cnt - 1);
        } else {
            sum = 4.0 / (2 * cnt - 1);
        }
        pi += sum;
    }
    console.log("计算了 " + (cnt - 1) + "次");
}