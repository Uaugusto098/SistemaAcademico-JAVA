-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14/05/2026 às 03:09
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
  MODIFY `codCurso` int(11) NOT NULL AUTO_INCREMENT;

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
