let storeArray = new Array;

function Store_Info(model, price, amount, brand, date) {
  this.model = model;
  this.price = price;
  this.amount = parseInt(amount);
  this.brand = brand;
  this.date = date;

  this.get_Model = function () {
    return this.model;
  }
  this.get_Price = function () {
    return this.price;
  }
  this.get_Amount = function () {
    return this.amount;
  }
  this.get_Brand = function () {
    return this.brand;
  }
  this.get_Date = function () {
    return this.date;
  }
  this.set_Model = function (model) {
    this.model = model;
  }
  this.set_Price = function (price) {
    this.price = price;
  }
  this.set_Amount = function (amount) {
    this.amount += parseInt(amount);
  }
  this.set_Brand = function (brand) {
    this.brand = brand;
  }
  this.set_Date = function (date) {
    this.date = date;
  }
}

function suminfo() {
  if (document.getElementById("model").value == ""
    || document.getElementById("price").value == ""
    || document.getElementById("amount").value == ""
    || document.getElementById("brand").value == ""
    || document.getElementById("date").value == "") {
    alert("정보 입력을 제대로 해주세요.")
    return false;
  }

  for (var i = 0; i < storeArray.length; i++) {
    if (storeArray[i].get_Model() == document.getElementById("model").value) {
      storeArray[i].set_Amount(document.getElementById("amount").value);
      storeArray[i].set_Price(document.getElementById("price").value);
      storeArray[i].set_Date(document.getElementById("date").value);

      alert("해당 상품에 대한 입고 처리가 완료되었습니다.");
      return false;
    }
  }

  storeArray[storeArray.length] = new Store_Info(
    document.getElementById("model").value,
    document.getElementById("price").value,
    document.getElementById("amount").value,
    document.getElementById("brand").value,
    document.getElementById("date").value
  );

  alert("기록에 없는 상품이여서 신상품으로 추가되었습니다.");
  return false;
}

function subinfo() {
  if (document.getElementById("model").value == ""
    || document.getElementById("amount").value == "") {
    alert("정보 입력을 제대로 해주세요.")
    return false;
  }

  for (var i = 0; i < storeArray.length; i++) {
    if (storeArray[i].get_Model() == document.getElementById("model").value) {
      storeArray[i].set_Amount(-(document.getElementById("amount").value));

      alert("해당 상품에 대한 출고 처리가 완료되었습니다.")
      return false;
    }
  }

  alert("해당 상품이 존재하지않습니다.")
  return false;
}

function putinfo() {
  if (document.getElementById("model").value == "") {
    alert("정보 입력을 제대로 해주세요.")
    return false;
  }

  let result = "";

  if (document.getElementById("model").value == "*") {
    for (var i = 0; i < storeArray.length; i++) {
      result += `<tr>
      <td>상품명 : ${storeArray[i].get_Model()}</td>
      <td>가격 : ${storeArray[i].get_Price()}</td>
      <td>수량 : ${storeArray[i].get_Amount()}</td>
      <td>제조사 : ${storeArray[i].get_Brand()}</td>
      <td>유통기한 : ${storeArray[i].get_Date()}</td></tr>`;
    }
  } else {
    for (var i = 0; i < storeArray.length; i++) {
      if (storeArray[i].get_Model() == document.getElementById("model").value) {
        result += `<tr>
        <td>상품명 : ${storeArray[i].get_Model()}</td>
        <td>가격 : ${storeArray[i].get_Price()}</td>
        <td>수량 : ${storeArray[i].get_Amount()}</td>
        <td>제조사 : ${storeArray[i].get_Brand()}</td>
        <td>유통기한 : ${storeArray[i].get_Date()}</td></tr>`;
      }
    }
  }

  if (result == "") {
    alert("검색 결과가 없습니다.");
    return false;
  } else {
    document.getElementById("put_list").innerHTML = result;
  }
}

function change_main(pick) {
  result = "";
  switch (pick) {
    case 1:
      result = `상품명 <input type="text" id="model" placeholder="상품을 입력하세요."><br>
        가격 &emsp;<input type="text" id="price"  placeholder="가격을 입력하세요."><br>
        수량 &emsp;<input type="text" id="amount"  placeholder="수량을 입력하세요."><br>
        제조사 <input type="text" id="brand"  placeholder="브랜드를 입력하세요." ><br>
        유통기한&emsp;&emsp;&emsp;&emsp;<input type="date" id="date"><br>`;
      document.getElementById("input_list").innerHTML = result;
      result = `<input type="button" onclick="suminfo()" value="저장">`;
      document.getElementById("button_input_2").innerHTML = result;
      document.getElementById("put_list").innerText = "";
      break;
    case 2:
      result = `상품명 <input type="text" id="model" placeholder="상품을 입력하세요."><br>
        수량 &emsp;<input type="text" id="amount"  placeholder="수량을 입력하세요."><br>`
      document.getElementById("input_list").innerHTML = result;
      result = `<input type="button" onclick="subinfo()" value="저장">`;
      document.getElementById("button_input_2").innerHTML = result;
      break;
    case 3:
      result = `<strong> * 를 입력시 모든 상품을 출력합니다. </strong><br>
        상품명 <input type="text" id="model" placeholder="상품을 입력하세요."><br>`
      document.getElementById("input_list").innerHTML = result;
      result = `<input type="button" onclick="putinfo()" value="출력">`;
      document.getElementById("button_input_2").innerHTML = result;
      break;
  }
}