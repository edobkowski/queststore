async function createCardsFromJson(jsonPath) {
    const cardsDiv = document.getElementById("cards-container");
    const cardsJson = await getJsonFromPath(jsonPath);
//    console.log(cardsJson);

    if (cardsJson.artifacts.length === 0) {
      return null;
    }

    addCards(cardsJson, cardsDiv);
}

async function getJsonFromPath(path) {
    const response = await fetch(path);
    return response.json();
}


function addCards(artifactsJson, cardDiv) {
    console.log("json: " + artifactsJson);

  for (let i = 0; i < artifactsJson.artifacts.length; i++) {
    const artifact = artifactsJson.artifacts[i];
    const filledCard = '<div class="col-lg-4 col-md-6">' +
                       '  <div class="card" style="min-height: 17em; margin-top: 3em;">' +
                       '    <div class="card-header bg-dark text-white">' + artifact.name + '</div>' +
                       '    <div class="card-body d-flex align-items-center">' +
                       '	    <p class="card-text">' + artifact.description + '</p>' +
                       '    </div>' +
                       '    <div class="card-footer text-right">' +
                       '        Buy for:<a href="#" class="btn btn-warning"><i class="fab fa-creative-commons"></i>' + artifact.price + '</a>' +
                       '    </div>' +
                       '  </div>' +
                       '</div>';

      cardDiv.innerHTML += filledCard;
  }
}

createCardsFromJson("http://127.0.0.1:8080/artifacts");