$(() => {
  const partNameEl = document.getElementById("partName");

  switch ($('#partCode').val()) {
    case 'A' :
      partNameEl.innerHTML = "경영";
      break;
    case 'B' :
      partNameEl.innerHTML = "사업";
      break;
    case 'C' :
      partNameEl.innerHTML = "운영";
      break;
    case 'D' :
      partNameEl.innerHTML = "연구";
      break;
    default :
      partNameEl.innerHTML = "없음";
  }

    console.log(progress);
    progress = progress.toFixed(2);
    document.getElementById("progressbar").style.width = progress + "%";
    document.getElementById("progress").innerHTML = progress + "%";

    var allScore = parseInt(document.getElementById("max_A").value) + parseInt(document.getElementById("max_B").value);
    document.getElementById("allScore").innerHTML = allScore;

    var partAllScore = parseInt(document.getElementById("yCountP_A").value) + parseInt(document.getElementById("yCountP_B").value);
    document.getElementById("partAllScore").innerHTML = partAllScore;

    var myAllScore = parseInt(document.getElementById("yCountU_A").value) + parseInt(document.getElementById("yCountU_B").value);
    document.getElementById("myAllScore").innerHTML = myAllScore;

})