function addLink(){
    var link = document.getElementById("link").value;
    var request = new XMLHttpRequest();

    request.open("POST", "/addLinkToShare", true);
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    request.send('link='+link);
}

function loadAllLinks(){
    var content = new XMLHttpRequest();
    content.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            document.getElementById("content").innerHTML = this.responseText;                    
        }
    }
    content.open("GET", "/loadAllLinks", true);
    content.send();
}

function cacheLink(link){
    console.log(link);
    console.log("Test");
}