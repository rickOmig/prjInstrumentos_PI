create database lojainstrumentos;
use lojainstrumentos;

CREATE TABLE `produtos` (
  `CodigoProduto` int(11) NOT NULL,
  `NomeProduto` varchar(100) NOT NULL,
  `DescricaoProduto` varchar(200) DEFAULT NULL,
  `Quantidade` int(11) DEFAULT NULL,
  `Preco` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`CodigoProduto`)
);

select * from produtos;
INSERT INTO `produtos` (CodigoProduto, NomeProduto, DescricaoProduto, Quantidade, Preco)
VALUES (1, 'nome', 'descricao', qtd, preco); 

CREATE TABLE `clientes` (
  `ClienteID` int(11) NOT NULL AUTO_INCREMENT,
  `NomeCompleto` varchar(100) NOT NULL,
  `CPF` varchar(11) DEFAULT NULL,
  `Endereco` varchar(200) DEFAULT NULL,
  `Telefone` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Genero` varchar(10) DEFAULT NULL,
  `EstadoCivil` varchar(20) DEFAULT NULL,
  `DataNascimento` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ClienteID`)
);

select * from clientes;
INSERT INTO `clientes` (ClienteID, NomeCompleto, CPF, Endereco, Telefone, Email, Genero, EstadoCivil, DataNascimento)
VALUES (1, 'nome', 'cpf', 'endereco', 'telefone', 'email', 'genero', 'estadocivil', 'datanascimento');

CREATE TABLE `venda` (
  `idVenda` int(11) NOT NULL AUTO_INCREMENT,
  `nome_produto` varchar(100) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `valorTotal` decimal(10,2) DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `ClienteID` int(11) NOT NULL,
  `dataCompra` timestamp NOT NULL DEFAULT current_timestamp(),
  `CodigoProduto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVenda`),
  KEY `ClienteID` (`ClienteID`),
  KEY `CodigoProduto` (`CodigoProduto`),
  CONSTRAINT `CodigoProduto` FOREIGN KEY (`CodigoProduto`) REFERENCES `produtos` (`CodigoProduto`),
  CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`ClienteID`) REFERENCES `clientes` (`ClienteID`)
);

select * from venda;
INSERT INTO `venda` (idVenda, nome_produto, quantidade, valorTotal, descricao, ClienteID, dataCompra, CodigoProduto)
VALUES (1, 'nome', qtd, valor, descricao, 1, 'dataCompra', 1);