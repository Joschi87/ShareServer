function addLink(){
    var link = document.getElementById("link").value;
    var request = new XMLHttpRequest();

    request.open("POST", "/addLinkToShare", true);
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    request.send('link='+link);
}

function loadAllLinks(){
    var output = "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css'><br /><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js'></script><script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js'></script><link href='open-iconic/font/css/open-iconic-bootstrap.css' rel='stylesheet'><br /><ul class='list-group'>";
    var content = new XMLHttpRequest();
    content.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
           var obj = JSON.parse(this.responseText);
           for(var ii = 0; ii < obj.length; ii++){
               output += "<li class='list-group-item'>" + obj[ii].link + "<div class='float-right'><a href='/deleteLink?id="+ obj[ii].id +"' target='_blank'><button class='btn btn-outline-danger btn-sm'>Delete</button></a></div></li>";
            }
            output += "</ul></html>";
            document.getElementById("content").innerHTML = output;
        }
    }
    content.open("GET", "/loadLinks", true);
    content.send();
}