// 아지나ㅉ제발넘힘들어요ㅠㅠ
$(document).on('click', '#add', function () {
    window.open("employee/list", "팝업 테스트", "width=800, height=600, top=20, left=40");
});


function createDIV() {
    var obj = document.getElementById("inputEmployee");
    var newDIV = document.createElement("div");
    newDIV.innerHTML = "새로 생성된 DIV입니다.";

    newDIV.setAttribute("id", "myDiv");

    newDIV.onclick = function () {
        var p = this.parentElement; // 부모 HTML 태그
        p.removeChild(this);    // 자신을 부모로부터 제거
    };
    obj.appendChild(newDIV);
}












