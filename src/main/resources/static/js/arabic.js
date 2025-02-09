const ararbicVideoList = [];

ararbicVideoList.push(fetch("http://localhost:8080/language/1").
then((response) => response.json()).
then((result) => result.videoDTOList));

setTimeout(ararbicVideoList.forEach(video => {
    console.log(video.link);
}), 2000);



