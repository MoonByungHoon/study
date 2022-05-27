let myArray = new Array;

function Car_Info(model, speed, color) {
    this.model = model; //this.를 붙는 순간 생성자이면서 클래스가 된다.
    this.speed = speed;
    this.color = color;

    this.set_Car_Info = function (model, speed, color) {
        this.model = model;
        this.speed = speed;
        this.color = color;
    }

    this.get_Model = function () {
        return this.model;
    }
}

function setinfo() {
    myArray[myArray.length] = new Car_Info();

    myArray[myArray.length - 1].set_Car_Info(
        document.getElementById("car_model_id").value,
        document.getElementById("car_speed_id").value, 
        document.getElementById("car_color_id").value)
}

function getinfo() {
    for (var i = 0; i <= myArray.length; i++) {
        if (myArray[i].get_Model() == document.getElementById("car_model_id").value) {
            document.getElementById("display1").innerHTML = myArray[i].model;
            document.getElementById("display2").innerHTML = myArray[i].speed;
            document.getElementById("display3").innerHTML = myArray[i].color;
            break;
        }
    }
}