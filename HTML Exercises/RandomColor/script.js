
const colors = [
    "#FF0000",   // Vermelho
    "#00FF00",   // Verde
    "#0000FF",   // Azul
    "#FFFF00",   // Amarelo
    "#00FFFF",   // Ciano
    "#FF00FF",   // Magenta
    "#800000",   // Vermelho escuro
    "#008000",   // Verde escuro
    "#000080",   // Azul escuro
    "#FFA500",   // Laranja
    "#4B0082",   // Índigo
    "#EE82EE",   // Orquídea
    "#FF6347",   // Tomate
    "#228B22",   // Verde floresta
    "#FFE4B5",   // Bege
    "#DDA0DD",   // Plum
    "#F08080",   // Salmão
    "#ADD8E6",   // Azul claro
    "#FF1493"    // Deep Pink
];
 
function selectColor(){
    const randomIndex = Math.floor(Math.random() * colors.length);
    return colors[randomIndex]
}


let selectColor1 = selectColor();
let selectColor2 = selectColor();
let selectColor3 = selectColor();
let selectColor4 = selectColor();
let selectColor5 = selectColor();


// randon color
document.getElementById("1").innerHTML = selectColor();
document.getElementById("1").style.backgroundColor = selectColor1;

document.getElementById("2").innerHTML = selectColor();
document.getElementById("2").style.backgroundColor = selectColor2;

document.getElementById("3").innerHTML = selectColor();
document.getElementById("3").style.backgroundColor = selectColor3;

document.getElementById("4").innerHTML = selectColor();
document.getElementById("4").style.backgroundColor = selectColor4;

document.getElementById("5").innerHTML = selectColor();
document.getElementById("5").style.backgroundColor = selectColor5;


