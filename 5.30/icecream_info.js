let iceArray = new Array;

function icecream_Info(brand, model, amount, user, day) {
    this.brand = brand;
    this.model = model; //this.를 붙는 순간 생성자이면서 클래스가 된다.
    this.amount = (parseInt(amount));
    this.user = user;
    this.day = day;
    

    this.get_Brand = function() {
        return this.brand;
    }
    this.get_Model = function() {
        return this.model;
    }
    this.get_Amount = function() {
        return this.amount;
    }
    this.get_User = function() {
        return this.user;
    }
    this.get_Day = function() {
        return this.day;
    }
}

function sum_icecream() { //입고
    let brand_name = document.getElementsByName('brand');
    
    brand_name.forEach((node) => {
        if(node.checked)  {
            brand_name = node.value;
        }
    }) 

    if(document.getElementById("model").value == "" 
        || document.getElementById("amount").value == "" 
        || document.getElementById("user").value == "" 
        || document.getElementById("day").value == ""
        || brand_name == ""){
        alert("정보 입력을 제대로 해주세요.")
        return false;
    }
    iceArray[iceArray.length] = new icecream_Info(
        brand_name,
        document.getElementById("model").value,
        document.getElementById("amount").value,
        document.getElementById("user").value,
        document.getElementById("day").value,
    );
}

function sub_icecream() { //출고
    let brand_name = document.getElementsByName('brand');
    let check = $('input[name=brand]').is(':checked');

    if($(':radio[name="brand"]:checked').length < 1) {   
        alert("1개 이상 선택해 주세요.");
        return;
     }

    brand_name.forEach((node) => {
      if(node.checked)  {
        brand_name = node.value;
      }
    }) 
    if(document.getElementById("model").value == "" 
        || document.getElementById("amount").value == "" 
        || document.getElementById("user").value == "" 
        || document.getElementById("day").value == ""
        || document.getElementsByName("brand").value == ""){
        alert("정보 입력을 제대로 해주세요.")
        return false;
    }
    iceArray[iceArray.length] = new icecream_Info(
        brand_name,
        document.getElementById("model").value,
        -(parseInt(document.getElementById("amount").value)),
        document.getElementById("user").value,
        document.getElementById("day").value,
    );
}

function put_icecream() { //제품에 대한 재고 출력
    if(document.getElementById("model_put").value == "" ){
        alert("정보 입력을 제대로 해주세요.")
        return false;
    }
    
    let result = 0;
    let brand_name = "";
    let model_put = document.getElementById("model_put").value
    let put_image = `<tr><td>날짜</td><td>브랜드</td>
    <td>상품</td><td>수량</td><td>근무자</td></tr>`;

    for (var i = 0; i < iceArray.length; i++) {
        if (iceArray[i].get_Model() == document.getElementById("model_put").value) {
            result += parseInt(iceArray[i].get_Amount());
            brand_name = iceArray[i].get_Brand();
        }
    }
    
    put_image += `<tr><td> </td><td>${brand_name}</td>
            <td>${model_put}</td><td>${result}</td>
            <td> </td></tr>`;

    document.getElementById("put_line").innerHTML = put_image;
}

function put_icecream_all() { //전체 출력
    let put_image = `<tr><td>날짜</td><td>브랜드</td>
    <td>상품</td><td>수량</td><td>근무자</td></tr>`;

    for (var i = 0; i < iceArray.length; i++) {
        put_image += `<tr><td>${iceArray[i].get_Day()}</td>
        <td>${iceArray[i].get_Brand()}</td>
        <td>${iceArray[i].get_Model()}</td>
        <td>${iceArray[i].get_Amount()}</td>
        <td>${iceArray[i].get_User()}</td></tr>`;
    }
    document.getElementById("put_line").innerHTML = put_image;
}