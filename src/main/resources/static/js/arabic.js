const ararbicLinkList = [];
const ararbicnameList = [];

async function getLinks() {
    let response = await fetch("http://localhost:8080/language/1").
    then((result) => result.json()).
    then((language) => language.videoDTOList);
    response.forEach(element => {
        ararbicLinkList.push(element.link)
    });
    return response;
}

async function fetchVideoNames() {
    let response = await fetch("http://localhost:8080/language/1").
    then((result) => result.json()).
    then((language) => language.videoDTOList);
    response.forEach(element => {
        ararbicnameList.push(element.name)
    });
    return response;
}

getLinks();
fetchVideoNames();
const btn = document.createElement("button");
btn.innerHTML = '<img src="http://img.youtube.com/ZMpekpfglxA?si=BqzAABfDOoKD5jSW.jpg" title="YouTube Video" alt="YouTube Video" />'
document.body.appendChild(btn);
console.log(ararbicLinkList);
console.log(ararbicnameList)
/*
ararbicVideoList = fetchVideos(fetchLink);

ararbicVideoList.array.forEach(element => {
    console.log(element.link);
});
console.log(ararbicVideoList);

ararbicVideoList = await fetch("http://localhost:8080/language/1").
then((response) => console.log(response.json())).
then((result) => result.videoDTOList).then((video) => video.link);

setTimeout(console.log(ararbicVideoList), 2000);


setTimeout(ararbicVideoList.forEach(video => {
    console.log(video.link);
}), 2000);
*/


