function validar() {

// Pegar Valores dos Campos através dos seus nomes
var campoCodigoMercadoria = frmCadastro.campoCodigoMercadoria.value;
var campoTipo = frmCadastro.campoTipo.value;
var campoNome = frmCadastro.campoNome.value;
var campoQuantidade = frmCadastro.campoQuantidade.value;
var campoPreco = frmCadastro.campoPreco.value;
var comboNegocio = frmCadastro.comboNegocio.value;

if (campoCodigoMercadoria == "") {
alert('Preencha Campo Codigo Mercadoria !');
frmCadastro.campoTipo.focus();
return false;
}

if (campoTipo == "") {
alert('Preencha o campo Tipo');
frmCadastro.campoTipo.focus();
return false;
}

if (campoNome == "") {
alert('Campo email Obrigatório.');
frmCadastro.campoNome.focus();
return false;
}

if(campoQuantidade <0 || campoQuantidade==""){
alert('Informe quantidade Maior que 0');
frmCadastro.campoQuantidade.focus();
return false;
}


if (campoPreco || campoPreco=="" ||campoPreco==0,00) {
alert('Campo Deve estar 0,00 ou em branco');
frmCadastro.campoPreco.focus();
return false;
}  



if (comboNegocio == "selecione") {
alert('Selecione Venda Ou Compra');
frmCadastro.comboNegocio.focus();
return false;
}  





return true;
}


function somente_numero(campo){
	
	if ( isNaN(campo.value)) {  
	       alert("Digite apenas números!");  
	       campo.value =""
	       return false;  
	} else {
	     return false;
	}
	}

function converterReal(valor){

	function currencyFormat (num) {
	    return num.toFixed(2).replace(".", ",").replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,")
	}
	}