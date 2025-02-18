let langName = null;
const fetchLink = "http://localhost:8080/language/"
const videoLinkList = [];
const videoNameList = [];
const divClassname = document.getElementById("videoInjector");
buildCards();

async function setLanguageName(fetchedLang) {
    console.log(fetchedLang);
    langName = fetchedLang;
    return true;
}

async function getLangId() {
    let id = -1;
    let response = await fetch("http://localhost:8080/language/getAll")
        .then((result) => result.json())
    response.forEach((element) => {
        if (langName === element.name) {
            id = element.id;
        }
    });
    return id;
}

async function getLinks() {
    const fetchedId = await getLangId();
    let actualLink = fetchLink.concat(fetchedId);
    console.log(actualLink);
    let response = await fetch(actualLink)
        .then((result) => result.json())
        .then((language) => language.videoDTOList);

    response.forEach((element) => {
        videoLinkList.push(element.link);
    });

    return response;
}

async function fetchVideoNames() {
    const fetchedId = await getLangId();
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

async function buildCards() {
   await setLanguageName();
    await getLinks();
    await fetchVideoNames();

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

