--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2019-03-25 16:40:25

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2843 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 201 (class 1259 OID 24600)
-- Name: answer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.answer (
    id bigint NOT NULL,
    reply bit varying(100) NOT NULL,
    response smallint NOT NULL
);


ALTER TABLE public.answer OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 24598)
-- Name: answer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.answer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.answer_id_seq OWNER TO postgres;

--
-- TOC entry 2844 (class 0 OID 0)
-- Dependencies: 200
-- Name: answer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.answer_id_seq OWNED BY public.answer.id;


--
-- TOC entry 197 (class 1259 OID 24578)
-- Name: exam; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exam (
    id bigint NOT NULL,
    name character varying(50) NOT NULL,
    date date NOT NULL,
    description character varying(250)
);


ALTER TABLE public.exam OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 24576)
-- Name: exam_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.exam_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.exam_id_seq OWNER TO postgres;

--
-- TOC entry 2845 (class 0 OID 0)
-- Dependencies: 196
-- Name: exam_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.exam_id_seq OWNED BY public.exam.id;


--
-- TOC entry 202 (class 1259 OID 24606)
-- Name: exam_question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exam_question (
    exam_id bigint NOT NULL,
    question_id bigint NOT NULL
);


ALTER TABLE public.exam_question OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 24586)
-- Name: question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.question (
    id bigint NOT NULL,
    question_text character varying(250) NOT NULL,
    scores smallint NOT NULL,
    notice character varying(200)
);


ALTER TABLE public.question OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 24621)
-- Name: question_answer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.question_answer (
    question_id bigint NOT NULL,
    answer_id bigint NOT NULL
);


ALTER TABLE public.question_answer OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 24584)
-- Name: question_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.question_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.question_id_seq OWNER TO postgres;

--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 198
-- Name: question_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.question_id_seq OWNED BY public.question.id;


--
-- TOC entry 2692 (class 2604 OID 24603)
-- Name: answer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.answer ALTER COLUMN id SET DEFAULT nextval('public.answer_id_seq'::regclass);


--
-- TOC entry 2690 (class 2604 OID 24581)
-- Name: exam id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam ALTER COLUMN id SET DEFAULT nextval('public.exam_id_seq'::regclass);


--
-- TOC entry 2691 (class 2604 OID 24589)
-- Name: question id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question ALTER COLUMN id SET DEFAULT nextval('public.question_id_seq'::regclass);


--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 200
-- Name: answer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.answer_id_seq', 1, false);


--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 196
-- Name: exam_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.exam_id_seq', 1, false);


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 198
-- Name: question_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.question_id_seq', 1, false);


--
-- TOC entry 2698 (class 2606 OID 24605)
-- Name: answer answer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.answer
    ADD CONSTRAINT answer_pkey PRIMARY KEY (id);


--
-- TOC entry 2694 (class 2606 OID 24583)
-- Name: exam exam_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam
    ADD CONSTRAINT exam_pkey PRIMARY KEY (id);


--
-- TOC entry 2700 (class 2606 OID 24610)
-- Name: exam_question exam_question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam_question
    ADD CONSTRAINT exam_question_pkey PRIMARY KEY (exam_id, question_id);


--
-- TOC entry 2702 (class 2606 OID 24625)
-- Name: question_answer question_answer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question_answer
    ADD CONSTRAINT question_answer_pkey PRIMARY KEY (question_id, answer_id);


--
-- TOC entry 2696 (class 2606 OID 24591)
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id);


--
-- TOC entry 2705 (class 2606 OID 24626)
-- Name: question_answer fk_answer; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question_answer
    ADD CONSTRAINT fk_answer FOREIGN KEY (answer_id) REFERENCES public.answer(id);


--
-- TOC entry 2704 (class 2606 OID 24616)
-- Name: exam_question fk_exam; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam_question
    ADD CONSTRAINT fk_exam FOREIGN KEY (exam_id) REFERENCES public.exam(id);


--
-- TOC entry 2703 (class 2606 OID 24611)
-- Name: exam_question fk_question; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam_question
    ADD CONSTRAINT fk_question FOREIGN KEY (question_id) REFERENCES public.question(id);


--
-- TOC entry 2706 (class 2606 OID 24631)
-- Name: question_answer fk_question; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question_answer
    ADD CONSTRAINT fk_question FOREIGN KEY (question_id) REFERENCES public.question(id);


-- Completed on 2019-03-25 16:40:25

--
-- PostgreSQL database dump complete
--

