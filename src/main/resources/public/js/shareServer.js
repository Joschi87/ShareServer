var request = new XMLHttpRequest();

function addLink(){
    var link = document.getElementById("link").value;

    var data = JSON.stringify({"link": link});

    request.open("POST", "/addLinkToShare", false);
    request.setRequestHeader('Content-Type', 'application/penis');
    request.send(data);

    request.onreadystatechange = function(){
        if (this.readyState === 4 && this.status === 201) {
            alert("Link add to database");
        }else{
            alert(this.status + "\n"+this.responseText);
        }
    }
}

function loadAllLinks(){
    request.onreadystatechange = function(){
        var output = "";
        if (this.readyState == 4 && this.status == 200) {
            var obj = JSON.parse(this.responseText);
            for (var ii = 0; ii < obj.length; ii++) {
                output += "<li class='list-group-item'>" + obj[ii].link + "<div class='float-right'><a href='/deleteLink?id=" + obj[ii].id + "' target='_blank'><button class='btn btn-outline-danger btn-sm'>Delete</button></a></div></li>";
            }
            document.getElementById("history-content").innerHTML = output;
        }
    }
    request.setRequestHeader("Accept", "application/json");
    request.open("GET", "/loadLinks", true);
    request.send();
}