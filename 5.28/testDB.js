let myArray = new Array;

function Car_Info(model, speed, color) {
    this.model = model; //this.를 붙는 순간 생성자이면서 클래스가 된다.
    this.speed = speed;
    this.color = color;

    this.get_Model = function () {
        return this.model;
    }
    this.get_Speed = function () {
        return this.speed;
    }
    this.get_Color = function () {
        return this.color;
    }
}

function setinfo() {
    myArray[myArray.length] = new Car_Info(
        document.getElementById("car_model_id").value,
        document.getElementById("car_speed_id").value,
        document.getElementById("car_color_id").value
    );
}

function getinfo() {
    for (var i = 0; i < myArray.length; i++) {
        if (myArray[i].get_Model() == document.getElementById("car_model_id").value) {
            document.getElementById("display1").innerHTML =
                `찾으시는 차량은 ${i+1}번째 차량이 입니다.<br>
                모델 : ${myArray[i].get_Model()}, 
                속도 :  ${myArray[i].get_Speed()}, 
                색상 : ${myArray[i].get_Color()}`;
            break;
        }
    }
}

function getinfo_all() {
    let result = "";
    for (var i = 0; i < myArray.length; i++) {
        result += `${i+1}번 차량   
            모델 : ${myArray[i].get_Model()},  
            속도 : ${myArray[i].get_Speed()},  
            색상 : ${myArray[i].get_Color()}<br>`;
    }
    document.getElementById("display2").innerHTML = result;
}