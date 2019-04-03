--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2019-04-03 15:42:24

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
-- TOC entry 2923 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 207 (class 1259 OID 25359)
-- Name: certificate; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.certificate (
    id bigint NOT NULL,
    "issueDate" date NOT NULL
);


ALTER TABLE public.certificate OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 25357)
-- Name: Certificate_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Certificate_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Certificate_id_seq" OWNER TO postgres;

--
-- TOC entry 2924 (class 0 OID 0)
-- Dependencies: 206
-- Name: Certificate_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Certificate_id_seq" OWNED BY public.certificate.id;


--
-- TOC entry 205 (class 1259 OID 25340)
-- Name: responseOption; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.responseOption (
    id bigint NOT NULL,
    reply_test character varying(100) NOT NULL,
    correct smallint NOT NULL
);


ALTER TABLE public.responseOption OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 25338)
-- Name: responseOption_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.responseOption_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.responseOption_id_seq OWNER TO postgres;

--
-- TOC entry 2925 (class 0 OID 0)
-- Dependencies: 204
-- Name: responseOption_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.responseOption_id_seq OWNED BY public.responseOption.id;


--
-- TOC entry 196 (class 1259 OID 25281)
-- Name: authority; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authority (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.authority OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 25284)
-- Name: authority_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.authority_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.authority_id_seq OWNER TO postgres;

--
-- TOC entry 2926 (class 0 OID 0)
-- Dependencies: 197
-- Name: authority_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.authority_id_seq OWNED BY public.authority.id;


--
-- TOC entry 198 (class 1259 OID 25286)
-- Name: authority_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authority_role (
    authority_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.authority_role OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 25378)
-- Name: completedExam; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."completedExam" (
    id bigint NOT NULL,
    score integer NOT NULL,
    passed smallint NOT NULL
);


ALTER TABLE public."completedExam" OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 25376)
-- Name: completedExam_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."completedExam_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."completedExam_id_seq" OWNER TO postgres;

--
-- TOC entry 2927 (class 0 OID 0)
-- Dependencies: 210
-- Name: completedExam_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."completedExam_id_seq" OWNED BY public."completedExam".id;


--
-- TOC entry 209 (class 1259 OID 25367)
-- Name: exam; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exam (
    id bigint NOT NULL,
    name character varying(50) NOT NULL,
    "startDate" date NOT NULL,
    "endDate" date NOT NULL,
    duration integer NOT NULL,
    "minimumScore" integer NOT NULL,
    users_id bigint NOT NULL
);


ALTER TABLE public.exam OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 25365)
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
-- TOC entry 2928 (class 0 OID 0)
-- Dependencies: 208
-- Name: exam_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.exam_id_seq OWNED BY public.exam.id;


--
-- TOC entry 217 (class 1259 OID 25403)
-- Name: exam_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exam_users (
    exam_id bigint NOT NULL,
    users_id bigint NOT NULL
);


ALTER TABLE public.exam_users OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 25388)
-- Name: question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.question (
    id bigint NOT NULL,
    "questionText" character varying(50) NOT NULL
);


ALTER TABLE public.question OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 25384)
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
-- TOC entry 2929 (class 0 OID 0)
-- Dependencies: 212
-- Name: question_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.question_id_seq OWNED BY public.question.id;


--
-- TOC entry 213 (class 1259 OID 25386)
-- Name: question_questionText_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."question_questionText_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."question_questionText_seq" OWNER TO postgres;

--
-- TOC entry 2930 (class 0 OID 0)
-- Dependencies: 213
-- Name: question_questionText_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."question_questionText_seq" OWNED BY public.question."questionText";


--
-- TOC entry 216 (class 1259 OID 25397)
-- Name: responseOption; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."responseOption" (
    id bigint NOT NULL,
    correct smallint NOT NULL
);


ALTER TABLE public."responseOption" OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 25395)
-- Name: responseOption_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."responseOption_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."responseOption_id_seq" OWNER TO postgres;

--
-- TOC entry 2931 (class 0 OID 0)
-- Dependencies: 215
-- Name: responseOption_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."responseOption_id_seq" OWNED BY public."responseOption".id;


--
-- TOC entry 199 (class 1259 OID 25289)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 25292)
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_id_seq OWNER TO postgres;

--
-- TOC entry 2932 (class 0 OID 0)
-- Dependencies: 200
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;


--
-- TOC entry 201 (class 1259 OID 25294)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    username character varying(255) NOT NULL,
    password character(60) NOT NULL,
    name character varying(50) NOT NULL,
    surname character varying(50) NOT NULL,
    account_expiration_date date NOT NULL,
    credentials_expiration_date date NOT NULL,
    locked smallint NOT NULL,
    enabled smallint NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 25297)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 2933 (class 0 OID 0)
-- Dependencies: 202
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 203 (class 1259 OID 25299)
-- Name: users_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_role (
    users_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.users_role OWNER TO postgres;

--
-- TOC entry 2735 (class 2604 OID 25343)
-- Name: responseOption id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responseOption ALTER COLUMN id SET DEFAULT nextval('public.responseOption_id_seq'::regclass);


--
-- TOC entry 2732 (class 2604 OID 25302)
-- Name: authority id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority ALTER COLUMN id SET DEFAULT nextval('public.authority_id_seq'::regclass);


--
-- TOC entry 2736 (class 2604 OID 25362)
-- Name: certificate id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.certificate ALTER COLUMN id SET DEFAULT nextval('public."Certificate_id_seq"'::regclass);


--
-- TOC entry 2738 (class 2604 OID 25381)
-- Name: completedExam id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."completedExam" ALTER COLUMN id SET DEFAULT nextval('public."completedExam_id_seq"'::regclass);


--
-- TOC entry 2737 (class 2604 OID 25370)
-- Name: exam id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam ALTER COLUMN id SET DEFAULT nextval('public.exam_id_seq'::regclass);


--
-- TOC entry 2739 (class 2604 OID 25391)
-- Name: question id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question ALTER COLUMN id SET DEFAULT nextval('public.question_id_seq'::regclass);


--
-- TOC entry 2740 (class 2604 OID 25392)
-- Name: question questionText; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question ALTER COLUMN "questionText" SET DEFAULT nextval('public."question_questionText_seq"'::regclass);


--
-- TOC entry 2741 (class 2604 OID 25400)
-- Name: responseOption id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."responseOption" ALTER COLUMN id SET DEFAULT nextval('public."responseOption_id_seq"'::regclass);


--
-- TOC entry 2733 (class 2604 OID 25303)
-- Name: role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- TOC entry 2734 (class 2604 OID 25304)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 2934 (class 0 OID 0)
-- Dependencies: 206
-- Name: Certificate_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Certificate_id_seq"', 1, false);


--
-- TOC entry 2935 (class 0 OID 0)
-- Dependencies: 204
-- Name: responseOption_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.responseOption_id_seq', 1, false);


--
-- TOC entry 2936 (class 0 OID 0)
-- Dependencies: 197
-- Name: authority_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.authority_id_seq', 6, true);


--
-- TOC entry 2937 (class 0 OID 0)
-- Dependencies: 210
-- Name: completedExam_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."completedExam_id_seq"', 1, false);


--
-- TOC entry 2938 (class 0 OID 0)
-- Dependencies: 208
-- Name: exam_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.exam_id_seq', 1, false);


--
-- TOC entry 2939 (class 0 OID 0)
-- Dependencies: 212
-- Name: question_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.question_id_seq', 1, false);


--
-- TOC entry 2940 (class 0 OID 0)
-- Dependencies: 213
-- Name: question_questionText_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."question_questionText_seq"', 1, false);


--
-- TOC entry 2941 (class 0 OID 0)
-- Dependencies: 215
-- Name: responseOption_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."responseOption_id_seq"', 1, false);


--
-- TOC entry 2942 (class 0 OID 0)
-- Dependencies: 200
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_id_seq', 6, true);


--
-- TOC entry 2943 (class 0 OID 0)
-- Dependencies: 202
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 4, true);


--
-- TOC entry 2753 (class 2606 OID 25345)
-- Name: responseOption responseOption_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.responseOption
    ADD CONSTRAINT responseOption_pkey PRIMARY KEY (id);


--
-- TOC entry 2743 (class 2606 OID 25306)
-- Name: authority authority_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority
    ADD CONSTRAINT authority_pkey PRIMARY KEY (id);


--
-- TOC entry 2745 (class 2606 OID 25308)
-- Name: authority_role authority_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority_role
    ADD CONSTRAINT authority_role_pkey PRIMARY KEY (authority_id, role_id);


--
-- TOC entry 2755 (class 2606 OID 25364)
-- Name: certificate certificate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.certificate
    ADD CONSTRAINT certificate_pkey PRIMARY KEY (id);


--
-- TOC entry 2759 (class 2606 OID 25383)
-- Name: completedExam completedExam_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."completedExam"
    ADD CONSTRAINT "completedExam_pkey" PRIMARY KEY (id);


--
-- TOC entry 2757 (class 2606 OID 25375)
-- Name: exam exam_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam
    ADD CONSTRAINT exam_pkey PRIMARY KEY (id);


--
-- TOC entry 2765 (class 2606 OID 25407)
-- Name: exam_users exam_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam_users
    ADD CONSTRAINT exam_users_pkey PRIMARY KEY (exam_id, users_id);


--
-- TOC entry 2761 (class 2606 OID 25394)
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id);


--
-- TOC entry 2763 (class 2606 OID 25402)
-- Name: responseOption responseOption_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."responseOption"
    ADD CONSTRAINT "responseOption_pkey" PRIMARY KEY (id);


--
-- TOC entry 2747 (class 2606 OID 25310)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 2749 (class 2606 OID 25312)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2751 (class 2606 OID 25314)
-- Name: users_role users_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT users_role_pkey PRIMARY KEY (users_id, role_id);


--
-- TOC entry 2766 (class 2606 OID 25315)
-- Name: authority_role fk_authority; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority_role
    ADD CONSTRAINT fk_authority FOREIGN KEY (authority_id) REFERENCES public.authority(id);


--
-- TOC entry 2771 (class 2606 OID 25408)
-- Name: exam_users fk_exam; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam_users
    ADD CONSTRAINT fk_exam FOREIGN KEY (exam_id) REFERENCES public.exam(id);


--
-- TOC entry 2767 (class 2606 OID 25320)
-- Name: authority_role fk_role; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authority_role
    ADD CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- TOC entry 2768 (class 2606 OID 25325)
-- Name: users_role fk_role; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES public.role(id);


--
-- TOC entry 2769 (class 2606 OID 25330)
-- Name: users_role fk_users; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_role
    ADD CONSTRAINT fk_users FOREIGN KEY (users_id) REFERENCES public.users(id);


--
-- TOC entry 2772 (class 2606 OID 25413)
-- Name: exam_users fk_users; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam_users
    ADD CONSTRAINT fk_users FOREIGN KEY (users_id) REFERENCES public.users(id);


--
-- TOC entry 2770 (class 2606 OID 25422)
-- Name: exam fk_users; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exam
    ADD CONSTRAINT fk_users FOREIGN KEY (users_id) REFERENCES public.users(id);


-- Completed on 2019-04-03 15:42:25

--
-- PostgreSQL database dump complete
--

