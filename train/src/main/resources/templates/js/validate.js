function validatePassword(){
            var pass2 = document.getElementById("password1").value;
            var pass1 = document.getElementById("password2").value;
            if(pass1 != pass2)
                document.getElementById("password2").setCustomValidity("Пароли не совпадают");
            else
                document.getElementById("password2").setCustomValidity('');
        }