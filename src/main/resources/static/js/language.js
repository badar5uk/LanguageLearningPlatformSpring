// var langName = "";
const fetchLink = "http://localhost:8080/language/"
const videoLinkList = [];
const videoNameList = [];
const divClassname = document.getElementById("videoInjector");


window.onload = function() {
    const langName = localStorage.getItem('langName'); // Retrieve langName from localStorage
    if (langName) {
        buildCards(langName);
    }
}


async function setLanguageName(fetchedLang) {
    console.log(fetchedLang); 
    localStorage.setItem('langName', fetchedLang);
}

async function getLangId(langName) {
    let id = -1;
    let response = await fetch("http://localhost:8080/language/getAll", {'Authorization': 'Bearer '.concat(localStorage.getItem('token'))})
        .then((result) => result.json());
    response.forEach((element) => {
        if (langName === element.name) {
            id = element.id;
        }
    });
    return id;
}

async function getLinks(langName) {
    const fetchedId = await getLangId(langName);
    let actualLink = fetchLink.concat(fetchedId);
    let response = await fetch(actualLink)
        .then((result) => result.json())
        .then((language) => language.videoDTOList);

    response.forEach((element) => {
        videoLinkList.push(element.link);
    });

    return response;
}

async function fetchVideoNames(langName) {
    const fetchedId = await getLangId(langName);
    let actualLink = fetchLink.concat(fetchedId);
    console.log(actualLink);
    let response = await fetch(actualLink)
        .then((result) => result.json())
        .then((language) => language.videoDTOList);

    response.forEach((element) => {
        videoNameList.push(element.name);
    });

    return response;
}

async function buildCards(langName) {
    await getLinks(langName);
    await fetchVideoNames(langName);

    // Clear existing content
    divClassname.innerHTML = "";

    for (let i = 0; i < videoLinkList.length; i++) {
        // Create card container
        const card = document.createElement("div");
        card.classList.add("video-card");

        // Create iframe for video
        const iframe = document.createElement("iframe");
        iframe.src = videoLinkList[i];
        iframe.width = "300";
        iframe.height = "200";
        iframe.allowFullscreen = true;
        iframe.classList.add("video-frame");

        // Create title
        const title = document.createElement("h3");
        title.textContent = videoNameList[i];

        // Append iframe and title to card
        card.appendChild(iframe);
        card.appendChild(title);

        // Append card to main container
        divClassname.appendChild(card);
    }
}

// Call function to build video cards

