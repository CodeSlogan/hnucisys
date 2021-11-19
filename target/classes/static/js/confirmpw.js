<script type="text/javascript">
function insertManager() {
    var password = document.getElementById("password").value;
    var repassword = document.getElementById("repassword").value;
         if(password!=repassword){
             window.alert("您输入的新密码与确认密码确认不一致");
             signupForm.repassword.focus();
             return false;
             }
          return true;
    }
</script>