const arabicLinkList = [];
const arabicNameList = [];
const divClassname = document.getElementById("videoInjector");

async function getLinks() {
  let response = await fetch("http://localhost:8080/language/1")
    .then((result) => result.json())
    .then((language) => language.videoDTOList);

  response.forEach((element) => {
    arabicLinkList.push(element.link);
  });

  return response;
}

async function fetchVideoNames() {
  let response = await fetch("http://localhost:8080/language/1")
    .then((result) => result.json())
    .then((language) => language.videoDTOList);

  response.forEach((element) => {
    arabicNameList.push(element.name);
  });

  return response;
}

async function buildCards() {
  await getLinks();
  await fetchVideoNames();

  // Clear existing content
  divClassname.innerHTML = "";

  for (let i = 0; i < arabicLinkList.length; i++) {
    // Create card container
    const card = document.createElement("div");
    card.classList.add("video-card");

    // Create iframe for video
    const iframe = document.createElement("iframe");
    iframe.src = arabicLinkList[i];
    iframe.width = "300";
    iframe.height = "200";
    iframe.allowFullscreen = true;
    iframe.classList.add("video-frame");

    // Create title
    const title = document.createElement("h3");
    title.textContent = arabicNameList[i];

    // Append iframe and title to card
    card.appendChild(iframe);
    card.appendChild(title);

    // Append card to main container
    divClassname.appendChild(card);
  }
}

// Call function to build video cards
buildCards();