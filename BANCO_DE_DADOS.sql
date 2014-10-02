-- CRIAÇÃO DO BANCO DE DADOS MYSQL
CREATE DATABASE  IF NOT EXISTS `topsearch_273`;
-- SELECIONA O BANCO DE DADOS A SER UTILIZADO
USE `topsearch_273`;

-- CRIA A TABELA 'MENSAGEM', CASO ELA JÁ EXISTA, SERÁ RE-CRIADA
DROP TABLE IF EXISTS `mensagem`;
CREATE TABLE `mensagem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `status` char(1) NOT NULL DEFAULT 'N',
  `mensagem1` varchar(140) DEFAULT NULL,
  `mensagem2` varchar(140) DEFAULT NULL,
  `mensagem3` varchar(140) DEFAULT NULL,
  `mensagem4` varchar(140) DEFAULT NULL,
  `mensagem5` varchar(140) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_usuario` (`id_usuario`),
  KEY `fk_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='Tabela de Mensagens da TopSearch';

-- CRIA A TABELA 'USUÁRIO', CASO ELA JÁ EXISTA, SERÁ RE-CRIADA
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sobrenome` varchar(100) NOT NULL,
  `ddd` varchar(2) NOT NULL,
  `telefone` varchar(9) NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `tw_oauth_token` varchar(255) NOT NULL,
  `tw_oauth_token_secret` varchar(255) NOT NULL,
  `fb_access_token` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1 COMMENT='Tabela de Usuários da TopSearch';
