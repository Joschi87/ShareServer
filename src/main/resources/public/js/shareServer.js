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
           //document.getElementById("content").innerHTML = this.responseText;
           myJSONParser(this.responseText);
        }
    }
    content.open("GET", "/loadLinks", true);
    content.send();
}

function cacheLink(link){
    console.log(link);
    console.log("Test");
}

function myJSONParser(txtToParse){
    var ii;
    var output;
    var obj = JSON.parse(txtToParse);
    for(ii = 0; ii < obj.length; ii++){
         output += obj[ii].link + " ,";
    }
    console.log(output);
}