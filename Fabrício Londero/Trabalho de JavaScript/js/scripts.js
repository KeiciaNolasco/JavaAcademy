document.getElementById('display-odds-button').addEventListener('click', mostrarImpares);
document.getElementById('calculate-sum-button').addEventListener('click', calcularSoma);

function mostrarImpares() {
    const inicio = parseInt(document.getElementById('odd-start').value);
    const fim = parseInt(document.getElementById('odd-end').value);
    const impares = [];
    for (let i = inicio; i <= fim; i++) {
        if (i % 2 !== 0) {
            impares.push(i);
        }
    }
    document.getElementById('odds').innerText = impares.join(', ');
}

function calcularSoma() {
    const fim = parseInt(document.getElementById('sum-end').value);
    let soma = 0;
    for (let i = 1; i <= fim; i++) {
        soma += i;
    }
    document.getElementById('sum').innerText = soma;
}
