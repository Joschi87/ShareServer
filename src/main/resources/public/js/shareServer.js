function addLink(){
    var link = document.getElementById("link").value;
    var request = new XMLHttpRequest();

    request.open("POST", "/addLinkToShare", true);
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    request.send('link='+link);
}

function loadAllLinks(){
    var output;
    var content = new XMLHttpRequest();
    content.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
           //document.getElementById("content").innerHTML = this.responseText;
           var obj = JSON.parse(this.responseText);
           for(var ii = 0; ii < obj.length; ii++){
               output += "<button type='button' class='btn btn-secondary'>" + obj[ii].link + "</button><br />";
            }
            document.getElementById("content").innerHTML = output;
        }
    }
    content.open("GET", "/loadLinks", true);
    content.send();
}

function cacheLink(link){
    console.log(link);
}