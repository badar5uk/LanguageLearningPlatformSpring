const fetchLink = "http://localhost:8080/language/1";
async function fetchVideos(fetchLink) {
    let response = await fetch(fetchLink).
    then((result) => result.json()).
    then((language) => language.videoDTOList);
    console.log(response);
    return response;
}
ararbicVideoList = fetchVideos(fetchLink);

ararbicVideoList.array.forEach(element => {
    console.log(element.link);
});
console.log(ararbicVideoList);

/*
ararbicVideoList = await fetch("http://localhost:8080/language/1").
then((response) => console.log(response.json())).
then((result) => result.videoDTOList).then((video) => video.link);

setTimeout(console.log(ararbicVideoList), 2000);


setTimeout(ararbicVideoList.forEach(video => {
    console.log(video.link);
}), 2000);
*/


