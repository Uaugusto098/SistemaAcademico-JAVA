-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18/05/2026 às 06:50
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `dbacademico`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbaluno`
--

CREATE TABLE `tbaluno` (
  `ra` bigint(20) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `celular` varchar(20) DEFAULT NULL,
  `dataNasc` date NOT NULL,
  `email` varchar(80) DEFAULT NULL,
  `endereco` text NOT NULL,
  `municipio` varchar(40) DEFAULT NULL,
  `uf` varchar(2) NOT NULL,
  `codCurso` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tbaluno`
--

INSERT INTO `tbaluno` (`ra`, `nome`, `cpf`, `celular`, `dataNasc`, `email`, `endereco`, `municipio`, `uf`, `codCurso`) VALUES
(1, 'pepepepe', '111.111.111-11', '(11) 11111-1111', '1111-11-11', 'sdsfs', 'fsfs', 'fds', 'SP', 1),
(2, 'pepepepe', '111.111.111-11', '(11) 11111-1111', '1111-11-11', 'sdsfs', 'fsfs', 'fds', 'SP', 2),
(3, 'sda', '111.111.999-99', '(11) 11111-9999', '1111-11-11', 'fsfsdsfs', 'fsdffsfs', 'fdsdsf', 'SP', 3),
(6, 'felipe', '111.999.888-23', '(11) 93829-0389', '2004-10-12', 'fdiniz@gmail', 'av santos', 'guarulhos', 'SP', 4);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbcurso`
--

CREATE TABLE `tbcurso` (
  `codCurso` int(11) NOT NULL,
  `nomeCurso` varchar(100) DEFAULT NULL,
  `periodo` varchar(20) DEFAULT NULL,
  `campus` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tbcurso`
--

INSERT INTO `tbcurso` (`codCurso`, `nomeCurso`, `periodo`, `campus`) VALUES
(1, 'Analise e Desenvolvimento de Sistemas', 'Matutino', 'Guarulhos'),
(2, 'Analise e Desenvolvimento de Sistemas', 'Vespertino', 'Guarulhos'),
(3, 'Analise e Desenvolvimento de Sistemas', 'Noturno', 'Guarulhos'),
(4, 'Analise e Desenvolvimento de Sistemas', 'Matutino', 'Itaquera'),
(5, 'Analise e Desenvolvimento de Sistemas', 'Vespertino', 'Itaquera'),
(6, 'Analise e Desenvolvimento de Sistemas', 'Noturno', 'Itaquera'),
(7, 'Analise e Desenvolvimento de Sistemas', 'Matutino', 'Ferraz de Vasconcelos'),
(8, 'Analise e Desenvolvimento de Sistemas', 'Vespertino', 'Ferraz de Vasconcelos'),
(9, 'Analise e Desenvolvimento de Sistemas', 'Noturno', 'Ferraz de Vasconcelos'),
(10, 'Comercio Exterior', 'Matutino', 'Guarulhos'),
(11, 'Comercio Exterior', 'Vespertino', 'Guarulhos'),
(12, 'Comercio Exterior', 'Noturno', 'Guarulhos'),
(13, 'Comercio Exterior', 'Matutino', 'Itaquera'),
(14, 'Comercio Exterior', 'Vespertino', 'Itaquera'),
(15, 'Comercio Exterior', 'Noturno', 'Itaquera'),
(16, 'Comercio Exterior', 'Matutino', 'Ferraz de Vasconcelos'),
(17, 'Comercio Exterior', 'Vespertino', 'Ferraz de Vasconcelos'),
(18, 'Comercio Exterior', 'Noturno', 'Ferraz de Vasconcelos'),
(19, 'Logistica', 'Matutino', 'Guarulhos'),
(20, 'Logistica', 'Vespertino', 'Guarulhos'),
(21, 'Logistica', 'Noturno', 'Guarulhos'),
(22, 'Logistica', 'Matutino', 'Itaquera'),
(23, 'Logistica', 'Vespertino', 'Itaquera'),
(24, 'Logistica', 'Noturno', 'Itaquera'),
(25, 'Logistica', 'Matutino', 'Ferraz de Vasconcelos'),
(26, 'Logistica', 'Vespertino', 'Ferraz de Vasconcelos'),
(27, 'Logistica', 'Noturno', 'Ferraz de Vasconcelos'),
(28, 'Gestao Empresarial', 'Matutino', 'Guarulhos'),
(29, 'Gestao Empresarial', 'Vespertino', 'Guarulhos'),
(30, 'Gestao Empresarial', 'Noturno', 'Guarulhos'),
(31, 'Gestao Empresarial', 'Matutino', 'Itaquera'),
(32, 'Gestao Empresarial', 'Vespertino', 'Itaquera'),
(33, 'Gestao Empresarial', 'Noturno', 'Itaquera'),
(34, 'Gestao Empresarial', 'Matutino', 'Ferraz de Vasconcelos'),
(35, 'Gestao Empresarial', 'Vespertino', 'Ferraz de Vasconcelos'),
(36, 'Gestao Empresarial', 'Noturno', 'Ferraz de Vasconcelos'),
(37, 'Logistica Aeroportuaria', 'Matutino', 'Guarulhos'),
(38, 'Logistica Aeroportuaria', 'Vespertino', 'Guarulhos'),
(39, 'Logistica Aeroportuaria', 'Noturno', 'Guarulhos'),
(40, 'Logistica Aeroportuaria', 'Matutino', 'Itaquera'),
(41, 'Logistica Aeroportuaria', 'Vespertino', 'Itaquera'),
(42, 'Logistica Aeroportuaria', 'Noturno', 'Itaquera'),
(43, 'Logistica Aeroportuaria', 'Matutino', 'Ferraz de Vasconcelos'),
(44, 'Logistica Aeroportuaria', 'Vespertino', 'Ferraz de Vasconcelos'),
(45, 'Logistica Aeroportuaria', 'Noturno', 'Ferraz de Vasconcelos'),
(46, 'Analise e Desenvolvimento de Sistemas', 'Matutino', 'Rio de Janeiro'),
(47, 'Analise e Desenvolvimento de Sistemas', 'Vespertino', 'Rio de Janeiro'),
(48, 'Analise e Desenvolvimento de Sistemas', 'Noturno', 'Rio de Janeiro'),
(49, 'Analise e Desenvolvimento de Sistemas', 'Matutino', 'Niteroi'),
(50, 'Analise e Desenvolvimento de Sistemas', 'Vespertino', 'Niteroi'),
(51, 'Analise e Desenvolvimento de Sistemas', 'Noturno', 'Niteroi'),
(52, 'Analise e Desenvolvimento de Sistemas', 'Matutino', 'Campo Grande'),
(53, 'Analise e Desenvolvimento de Sistemas', 'Vespertino', 'Campo Grande'),
(54, 'Analise e Desenvolvimento de Sistemas', 'Noturno', 'Campo Grande'),
(55, 'Analise e Desenvolvimento de Sistemas', 'Matutino', 'Vitoria'),
(56, 'Analise e Desenvolvimento de Sistemas', 'Vespertino', 'Vitoria'),
(57, 'Analise e Desenvolvimento de Sistemas', 'Noturno', 'Vitoria'),
(58, 'Analise e Desenvolvimento de Sistemas', 'Matutino', 'Belo Horizonte'),
(59, 'Analise e Desenvolvimento de Sistemas', 'Vespertino', 'Belo Horizonte'),
(60, 'Analise e Desenvolvimento de Sistemas', 'Noturno', 'Belo Horizonte'),
(61, 'Analise e Desenvolvimento de Sistemas', 'Matutino', 'Uberlandia'),
(62, 'Analise e Desenvolvimento de Sistemas', 'Vespertino', 'Uberlandia'),
(63, 'Analise e Desenvolvimento de Sistemas', 'Noturno', 'Uberlandia'),
(64, 'Analise e Desenvolvimento de Sistemas', 'Matutino', 'Porto Alegre'),
(65, 'Analise e Desenvolvimento de Sistemas', 'Vespertino', 'Porto Alegre'),
(66, 'Analise e Desenvolvimento de Sistemas', 'Noturno', 'Porto Alegre'),
(67, 'Comercio Exterior', 'Matutino', 'Rio de Janeiro'),
(68, 'Comercio Exterior', 'Vespertino', 'Rio de Janeiro'),
(69, 'Comercio Exterior', 'Noturno', 'Rio de Janeiro'),
(70, 'Comercio Exterior', 'Matutino', 'Niteroi'),
(71, 'Comercio Exterior', 'Vespertino', 'Niteroi'),
(72, 'Comercio Exterior', 'Noturno', 'Niteroi'),
(73, 'Comercio Exterior', 'Matutino', 'Campo Grande'),
(74, 'Comercio Exterior', 'Vespertino', 'Campo Grande'),
(75, 'Comercio Exterior', 'Noturno', 'Campo Grande'),
(76, 'Comercio Exterior', 'Matutino', 'Vitoria'),
(77, 'Comercio Exterior', 'Vespertino', 'Vitoria'),
(78, 'Comercio Exterior', 'Noturno', 'Vitoria'),
(79, 'Comercio Exterior', 'Matutino', 'Belo Horizonte'),
(80, 'Comercio Exterior', 'Vespertino', 'Belo Horizonte'),
(81, 'Comercio Exterior', 'Noturno', 'Belo Horizonte'),
(82, 'Comercio Exterior', 'Matutino', 'Uberlandia'),
(83, 'Comercio Exterior', 'Vespertino', 'Uberlandia'),
(84, 'Comercio Exterior', 'Noturno', 'Uberlandia'),
(85, 'Comercio Exterior', 'Matutino', 'Porto Alegre'),
(86, 'Comercio Exterior', 'Vespertino', 'Porto Alegre'),
(87, 'Comercio Exterior', 'Noturno', 'Porto Alegre'),
(88, 'Logistica', 'Matutino', 'Rio de Janeiro'),
(89, 'Logistica', 'Vespertino', 'Rio de Janeiro'),
(90, 'Logistica', 'Noturno', 'Rio de Janeiro'),
(91, 'Logistica', 'Matutino', 'Niteroi'),
(92, 'Logistica', 'Vespertino', 'Niteroi'),
(93, 'Logistica', 'Noturno', 'Niteroi'),
(94, 'Logistica', 'Matutino', 'Campo Grande'),
(95, 'Logistica', 'Vespertino', 'Campo Grande'),
(96, 'Logistica', 'Noturno', 'Campo Grande'),
(97, 'Logistica', 'Matutino', 'Vitoria'),
(98, 'Logistica', 'Vespertino', 'Vitoria'),
(99, 'Logistica', 'Noturno', 'Vitoria'),
(100, 'Logistica', 'Matutino', 'Belo Horizonte'),
(101, 'Logistica', 'Vespertino', 'Belo Horizonte'),
(102, 'Logistica', 'Noturno', 'Belo Horizonte'),
(103, 'Logistica', 'Matutino', 'Uberlandia'),
(104, 'Logistica', 'Vespertino', 'Uberlandia'),
(105, 'Logistica', 'Noturno', 'Uberlandia'),
(106, 'Logistica', 'Matutino', 'Porto Alegre'),
(107, 'Logistica', 'Vespertino', 'Porto Alegre'),
(108, 'Logistica', 'Noturno', 'Porto Alegre'),
(109, 'Gestao Empresarial', 'Matutino', 'Rio de Janeiro'),
(110, 'Gestao Empresarial', 'Vespertino', 'Rio de Janeiro'),
(111, 'Gestao Empresarial', 'Noturno', 'Rio de Janeiro'),
(112, 'Gestao Empresarial', 'Matutino', 'Niteroi'),
(113, 'Gestao Empresarial', 'Vespertino', 'Niteroi'),
(114, 'Gestao Empresarial', 'Noturno', 'Niteroi'),
(115, 'Gestao Empresarial', 'Matutino', 'Campo Grande'),
(116, 'Gestao Empresarial', 'Vespertino', 'Campo Grande'),
(117, 'Gestao Empresarial', 'Noturno', 'Campo Grande'),
(118, 'Gestao Empresarial', 'Matutino', 'Vitoria'),
(119, 'Gestao Empresarial', 'Vespertino', 'Vitoria'),
(120, 'Gestao Empresarial', 'Noturno', 'Vitoria'),
(121, 'Gestao Empresarial', 'Matutino', 'Belo Horizonte'),
(122, 'Gestao Empresarial', 'Vespertino', 'Belo Horizonte'),
(123, 'Gestao Empresarial', 'Noturno', 'Belo Horizonte'),
(124, 'Gestao Empresarial', 'Matutino', 'Uberlandia'),
(125, 'Gestao Empresarial', 'Vespertino', 'Uberlandia'),
(126, 'Gestao Empresarial', 'Noturno', 'Uberlandia'),
(127, 'Gestao Empresarial', 'Matutino', 'Porto Alegre'),
(128, 'Gestao Empresarial', 'Vespertino', 'Porto Alegre'),
(129, 'Gestao Empresarial', 'Noturno', 'Porto Alegre'),
(130, 'Logistica Aeroportuaria', 'Matutino', 'Rio de Janeiro'),
(131, 'Logistica Aeroportuaria', 'Vespertino', 'Rio de Janeiro'),
(132, 'Logistica Aeroportuaria', 'Noturno', 'Rio de Janeiro'),
(133, 'Logistica Aeroportuaria', 'Matutino', 'Niteroi'),
(134, 'Logistica Aeroportuaria', 'Vespertino', 'Niteroi'),
(135, 'Logistica Aeroportuaria', 'Noturno', 'Niteroi'),
(136, 'Logistica Aeroportuaria', 'Matutino', 'Campo Grande'),
(137, 'Logistica Aeroportuaria', 'Vespertino', 'Campo Grande'),
(138, 'Logistica Aeroportuaria', 'Noturno', 'Campo Grande'),
(139, 'Logistica Aeroportuaria', 'Matutino', 'Vitoria'),
(140, 'Logistica Aeroportuaria', 'Vespertino', 'Vitoria'),
(141, 'Logistica Aeroportuaria', 'Noturno', 'Vitoria'),
(142, 'Logistica Aeroportuaria', 'Matutino', 'Belo Horizonte'),
(143, 'Logistica Aeroportuaria', 'Vespertino', 'Belo Horizonte'),
(144, 'Logistica Aeroportuaria', 'Noturno', 'Belo Horizonte'),
(145, 'Logistica Aeroportuaria', 'Matutino', 'Uberlandia'),
(146, 'Logistica Aeroportuaria', 'Vespertino', 'Uberlandia'),
(147, 'Logistica Aeroportuaria', 'Noturno', 'Uberlandia'),
(148, 'Logistica Aeroportuaria', 'Matutino', 'Porto Alegre'),
(149, 'Logistica Aeroportuaria', 'Vespertino', 'Porto Alegre'),
(150, 'Logistica Aeroportuaria', 'Noturno', 'Porto Alegre');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbdesempenho`
--

CREATE TABLE `tbdesempenho` (
  `idDesempenho` int(11) NOT NULL,
  `ra` bigint(20) NOT NULL,
  `codDisciplina` int(11) DEFAULT NULL,
  `nota` decimal(4,2) DEFAULT 0.00,
  `faltas` int(11) DEFAULT 0,
  `semestre` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tbdesempenho`
--

INSERT INTO `tbdesempenho` (`idDesempenho`, `ra`, `codDisciplina`, `nota`, `faltas`, `semestre`) VALUES
(19, 6, 2, 10.00, 2, '2024-1'),
(20, 6, 3, 10.00, 3, '2024-1');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbdisciplinas`
--

CREATE TABLE `tbdisciplinas` (
  `codDisciplina` int(11) NOT NULL,
  `codCurso` int(11) DEFAULT NULL,
  `nomeDisciplina` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tbdisciplinas`
--

INSERT INTO `tbdisciplinas` (`codDisciplina`, `codCurso`, `nomeDisciplina`) VALUES
(1, 1, 'Programação Orientada a Objetos'),
(2, 1, 'Banco de Dados'),
(3, 1, 'Estrutura de Dados');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tbaluno`
--
ALTER TABLE `tbaluno`
  ADD PRIMARY KEY (`ra`),
  ADD KEY `codCurso` (`codCurso`);

--
-- Índices de tabela `tbcurso`
--
ALTER TABLE `tbcurso`
  ADD PRIMARY KEY (`codCurso`);

--
-- Índices de tabela `tbdesempenho`
--
ALTER TABLE `tbdesempenho`
  ADD PRIMARY KEY (`idDesempenho`),
  ADD KEY `fk_ra_aluno` (`ra`),
  ADD KEY `fk_disciplina` (`codDisciplina`);

--
-- Índices de tabela `tbdisciplinas`
--
ALTER TABLE `tbdisciplinas`
  ADD PRIMARY KEY (`codDisciplina`),
  ADD KEY `codCurso` (`codCurso`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbcurso`
--
ALTER TABLE `tbcurso`
  MODIFY `codCurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;

--
-- AUTO_INCREMENT de tabela `tbdesempenho`
--
ALTER TABLE `tbdesempenho`
  MODIFY `idDesempenho` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de tabela `tbdisciplinas`
--
ALTER TABLE `tbdisciplinas`
  MODIFY `codDisciplina` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `tbaluno`
--
ALTER TABLE `tbaluno`
  ADD CONSTRAINT `tbaluno_ibfk_1` FOREIGN KEY (`codCurso`) REFERENCES `tbcurso` (`codCurso`);

--
-- Restrições para tabelas `tbdesempenho`
--
ALTER TABLE `tbdesempenho`
  ADD CONSTRAINT `fk_disciplina` FOREIGN KEY (`codDisciplina`) REFERENCES `tbdisciplinas` (`codDisciplina`),
  ADD CONSTRAINT `fk_ra_aluno` FOREIGN KEY (`ra`) REFERENCES `tbaluno` (`ra`);

--
-- Restrições para tabelas `tbdisciplinas`
--
ALTER TABLE `tbdisciplinas`
  ADD CONSTRAINT `tbdisciplinas_ibfk_1` FOREIGN KEY (`codCurso`) REFERENCES `tbcurso` (`codCurso`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
