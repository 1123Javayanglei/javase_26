function uppercaseToLowercaseAndLowercaseToUppercaseAndDelNumber(s) {
    // TODO 1:写一个方法：把参数字符串：大写转换为小写 小写转换为大写 删除数字
    if (typeof s != "string") {
        // 若不是字符串，跳出
        return;

    }
    let temp = "";
    // 记录
    for (let i = 0; i < s.length; i++) {
        let char = s.charAt(i);
        // 把字符提出来
        /**
         * 编码：
         * a = 97
         * z = 122
         * A = 65
         * Z = 90
         * 0 = 48
         * 9 = 47
         */
        if (char >= "a" && char <= "z") {
            // 是小写字母
            temp += char.toUpperCase();
            // 转换成大写，放进temp
        } else if (char >= "A" && char <= "Z") {
            // 是大写
            temp += char.toLowerCase();
            // 转换成小写，放进temp
        } else if (char >= "0" && char <= "9") {
            // 是数字,啥都不做
        } else {
            temp += char;
        }
    }
    return temp;
}

function getStingOutNumber(s) {
    // TODO 获取参数字符串的数字，再组成一个整数
    if (typeof s != "string") {
        // 若不是字符串，跳出
        return;
    }
    let temp = "";
    // 记录
    for (let i = 0; i < s.length; i++) {
        let char = s.charAt(i);
        // 获取
        if (char >= "0" && char <= "9") {
            // 如果是数字,放进temp
            temp += char;
        }
    }
    return temp;
}

function getTheStringInCharTime(s, c) {
    // TODO 获取字符串s中，字串c出现的次数
    if (typeof s != "string" || typeof c != "string") {
        // 若不是字符串，跳出
        return;
    }
    let cnt = 0;
    for (let temp in s) {
        if (temp === c) {
            // 如果相等说明出现了，次数+1
            cnt++;
        }
    }
    return cnt;
}

