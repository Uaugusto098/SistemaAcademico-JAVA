-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18/05/2026 às 00:49
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
  `celular` varchar(14) DEFAULT NULL,
  `dataNasc` date NOT NULL,
  `email` varchar(80) DEFAULT NULL,
  `endereco` text NOT NULL,
  `municipio` varchar(40) DEFAULT NULL,
  `uf` varchar(2) NOT NULL,
  `codCurso` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(45, 'Logistica Aeroportuaria', 'Noturno', 'Ferraz de Vasconcelos');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbdesempenho`
--

CREATE TABLE `tbdesempenho` (
  `idDesempenho` int(11) NOT NULL,
  `ra` bigint(20) NOT NULL,
  `codDisciplina` int(11) NOT NULL,
  `nota` decimal(4,2) DEFAULT 0.00,
  `faltas` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  ADD KEY `fk_ra_aluno` (`ra`);

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
  MODIFY `codCurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT de tabela `tbdesempenho`
--
ALTER TABLE `tbdesempenho`
  MODIFY `idDesempenho` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbdisciplinas`
--
ALTER TABLE `tbdisciplinas`
  MODIFY `codDisciplina` int(11) NOT NULL AUTO_INCREMENT;

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
