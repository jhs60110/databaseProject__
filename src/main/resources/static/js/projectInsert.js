let cnt=1;
// 아지나ㅉ제발넘힘들어요ㅠㅠ
$(document).on('click', '#add', function () {
    window.open("/project/employee/list", "팝업 테스트", "width=800, height=600, top=20, left=40");
});

$('.pChoose').on('click', (e) => {
    console.log(e.target.value);
    location.href="/project/projectEmploAppend/"+e.target.value ;
})


const addBtn = document.getElementById("addn");
const minusBtn=document.getElementById("minus");
const clientList=document.getElementById("clientList");
const eeee_id=document.getElementById("eeee_id");
const eee_name=document.getElementById("eee_name");
const pp_des=document.getElementById("pp_des");
const pp_start_date=document.getElementById("pp_start_date");
const pp_end_date=document.getElementById("pp_end_date");
const pp_role=document.getElementById("pp_role");


const rr=document.getElementById('td_id'+cnt);

const tr=document.getElementById('tr'+cnt);



function addInput(){

    const tr = document.createElement('tr');
    tr.setAttribute('id','tr'+cnt);
    clientList.appendChild(tr);

    const element1=document.createElement('td');
    element1.setAttribute('id','td_id'+cnt);
    tr.appendChild(element1);

    const elementa=document.createElement('td');
    elementa.setAttribute('id','td_namw'+cnt);
    tr.appendChild(elementa);

    const elementb=document.createElement('td');
    elementb.setAttribute('id','td_p_des'+cnt);
    tr.appendChild(elementb);

    const elementc=document.createElement('td');
    elementc.setAttribute('id','td_start'+cnt);
    tr.appendChild(elementc);

    const elementd=document.createElement('td');
    elementd.setAttribute('id','td_end'+cnt);
    tr.appendChild(elementd);

    const elemente=document.createElement('td');
    elemente.setAttribute('id','td_role'+cnt);
    tr.appendChild(elemente);

    const element2=document.createElement('input');
    element2.setAttribute('id','e_id'+cnt);
    // element2.setAttribute('id','e_id');

    element2.setAttribute('class','inputText')
    element2.setAttribute('type','text');
    element2.setAttribute('value',' ');
    element1.appendChild(element2);

    const element3=document.createElement('input');
    element3.setAttribute('id','e_name'+cnt);
    element3.setAttribute('class','inputText')
    element3.setAttribute('type','text');
    element3.setAttribute('value',' ');
    elementa.appendChild(element3);

    const element4=document.createElement('input');
    element4.setAttribute('id','p_des');
    element4.setAttribute('class','inputText')
    element4.setAttribute('type','text');
    element4.setAttribute('value',' ');
    elementb.appendChild(element4);

    const element5=document.createElement('input');
    element5.setAttribute('id','p_start_date'+cnt );
    element5.setAttribute('class','inputText')
    element5.setAttribute('type','text');
    element5.setAttribute('value',' ');
    elementc.appendChild(element5);

    const element6=document.createElement('input');
    element6.setAttribute('id','p_end_date'+cnt );
    element6.setAttribute('class','inputText')
    element6.setAttribute('type','text');
    element6.setAttribute('value',' ');
    elementd.appendChild(element6);

    const element7=document.createElement('input');
    element7.setAttribute('id','p_role'+cnt );
    element7.setAttribute('class','inputText')
    element7.setAttribute('type','text');
    element7.setAttribute('value',' ');
    elemente.appendChild(element7);




    // const element8=document.createElement('input');
    // element8.setAttribute('id','add'+cnt );
    // element8.setAttribute('type','button');
    // element8.setAttribute('value','추가'); //?
    // element8.setAttribute('onclick','popUpp()');
    // clientList.appendChild(element8);


    const element8=document.createElement('input');
    element8.setAttribute('id','add'+cnt );
    element8.setAttribute('class','bubu');
    element8.setAttribute('value','추가')//?
    element8.setAttribute('onclick','popUpp(event)');
    element8.setAttribute('type','button');
    clientList.appendChild(element8);

    clientList.innerHTML=clientList.innerHTML+'<br><br><br><br>';

    cnt = cnt+1;
}

popupButtonId =[];
console.log("이거언제실행?");
var aa =1;

function popUpp(e) {
    // console.log(e.target.id);

    popupButtonId.push(e.target.id);
    aa = popupButtonId[0].replace('add','');
    console.log("popup"+aa);


    // // window.name = "부모창 이름";
    // window.name = "parentForm";
    // // window.open("open할 window", "자식창 이름", "팝업창 옵션");
    // openWin = window.open("/project/employee/list",
    //     "childForm", "width=800, height=600, top=20, left=40");
    // window.open("<c:url value='/project/employee/list?nameChk="+6+"'/>", "팝업 테스트", "width=800, height=600, top=20, left=40");

    window.open("/project/employee/list?n="+aa, "팝업 테스트", "width=800, height=600, top=20, left=40");
    console.log(aa);
    popupButtonId =[];
    return aa;

}


var ListSaveSurveyLineRequestDto = new Array(cnt);
for (var idx = 1; idx < cnt+1; idx++) {
    let sample = [6];
    sample[0] = $('#e_id' + idx).val();                          //ELID
    sample[1] = $('#pr_id').val();                                              //USERID
    sample[2] = $('#p_des' + idx ).val();
    sample[3] = $('#p_start_date' + idx).val();                                  //판단근거
    sample[4] = $('#p_end_date' + idx).val();
    sample[5] = $('#p_role' + idx).val();
    ListSaveSurveyLineRequestDto[idx] = sample;
}
var allData = {
    "responses": ListSaveSurveyLineRequestDto //응답관련 리스트
};
$.ajax({
    url: '/project/projectEmploAppend/' + input, //EstimateController  @PostMapping(value = "/{input}" )와 연결
    type: 'POST',
    data: JSON.stringify(allData),
    processData: false,
    async: false,
    cache: false,
    contentType: "application/json; charset=utf-8",
    beforeSend: function (jqXHR, settings) {
        var header = $("meta[name='_csrf_header']").attr("content");
        var token = $("meta[name='_csrf']").attr("content");
        jqXHR.setRequestHeader(header, token);
    }
})









