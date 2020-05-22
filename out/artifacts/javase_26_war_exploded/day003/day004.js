$(function () {
    // 给表单注册事件，提交判断userName和userPwd是否为空，若为空，则不能提交
    $("form").bind("submit",function () {
        let userName = $("input[name='userName']").val().trim();
        let userPwd = $("input[name='userPwd']").val().trim();
        if (userName&&userPwd){
            return true;
        }else {
            alert("账户/密码不能为空")
            return false;
        }
    })
})