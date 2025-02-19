var tutorName = "";
const tutorFetchLink = "http://localhost:8080/tutor/getTutorVideos?tutorId="
const tutorVideoLinkList = [];
const tutorVideoNameList = [];
const divClassname1 = document.getElementById("videoInjector");


window.onload = function() {
    const tutorName = localStorage.getItem('tutorName'); // Retrieve tutorName from localStorage
    if (tutorName) {
        buildCards(tutorName);
    }
}


async function setTutorName(fetchTutor) {
    console.log(fetchTutor); 
    localStorage.setItem('tutorName', fetchTutor);
}

async function getLangId(tutorName) {
    let id = -1;
    let response = await fetch("http://localhost:8080/tutor/getAll")
        .then((result) => result.json())
    response.forEach((element) => {
        if (tutorName === element.name) {
            id = element.id;
        }
    });
    return id;
}

async function getLinks(tutorName) {
    const fetchedId = await getLangId(tutorName);
    let actualLink = tutorFetchLink.concat(fetchedId);
    console.log(actualLink);
    let response = await fetch(actualLink)
        .then((result) => result.json())
        .then((tutor) => tutor.tutorVideo);

    response.forEach((element) => {
        tutorVideoLinkList.push(element.link);
    });

    return response;
}


async function fetchVideoNames(tutorName) {
    const fetchedId = await getLangId(tutorName);
    let actualLink = tutorFetchLink.concat(fetchedId);
    console.log(actualLink);
    let response = await fetch(actualLink)
        .then((result) => result.json())
        .then((tutor) => tutor.tutorVideo);

    response.forEach((element) => {
        tutorVideoNameList.push(element.title);
    });

    return response;
}


async function buildCards(tutorName) {
    await getLinks(tutorName);
    await fetchVideoNames(tutorName);

    // Clear existing content
    divClassname1.innerHTML = "";

    for (let i = 0; i < tutorVideoLinkList.length; i++) {
        // Create card container
        const card = document.createElement("div");
        card.classList.add("video-card");

        // Create iframe for video
        const iframe = document.createElement("iframe");
        iframe.src = tutorVideoLinkList[i];
        iframe.width = "300";
        iframe.height = "200";
        iframe.allowFullscreen = true;
        iframe.classList.add("video-frame");

        // Create title
        const title = document.createElement("h3");
        title.textContent = tutorVideoNameList[i];

        // Append iframe and title to card
        card.appendChild(iframe);
        card.appendChild(title);

        // Append card to main container
        divClassname1.appendChild(card);
    }
}

// Call function to build video cards

