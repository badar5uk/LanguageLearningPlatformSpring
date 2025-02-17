async function getresponse(){
    var selectorOpt = document.getElementById("languages");
    var  selectorLang = selectorOpt.options[selectorOpt.selectedIndex].text;
    const inputText = document.getElementById("testinput").value;
    console.log(inputText);

    if(selectorLang != 'language'){

    let input = 'http://localhost:8080/api/v1/llm'.concat("/")
    .concat('translate ').concat(inputText).concat(' to ').concat(selectorLang);
  
    let aiResponse = fetch(input).then(res => {
    var reader = res.body.getReader();
  
    var i = 1;
    var pump = reader =>
        reader.read().then(({done, value}) => {
          console.info(i++, new TextDecoder("utf-8").decode(value));
          if (!done) {
            // Subsequent read() when it's not done yet
            return pump(reader);
          }
        });
  
    // Initial read()
    pump(reader);
  });
  }
}
  getresponse();