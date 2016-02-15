-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 15, 2016 at 11:52 PM
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `health_care`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblchat`
--

CREATE TABLE IF NOT EXISTS `tblchat` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user` varchar(50) NOT NULL,
  `message` varchar(500) NOT NULL,
  `dated` datetime NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `tblchat`
--


-- --------------------------------------------------------

--
-- Table structure for table `tblclinic`
--

CREATE TABLE IF NOT EXISTS `tblclinic` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `docid` int(7) NOT NULL,
  `roomno` int(7) NOT NULL,
  `timing` varchar(10) NOT NULL,
  `status` varchar(50) NOT NULL,
  `dated` date NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tblclinic`
--

INSERT INTO `tblclinic` (`id`, `docid`, `roomno`, `timing`, `status`, `dated`) VALUES
(1, 1, 201, '10:00 AM', 'Open', '2016-02-13'),
(2, 2, 202, '10:00 AM', 'Open', '2016-02-14');

-- --------------------------------------------------------

--
-- Table structure for table `tbldiagnosis`
--

CREATE TABLE IF NOT EXISTS `tbldiagnosis` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `shortcode` varchar(10) NOT NULL,
  `rate` double NOT NULL,
  `dated` varchar(50) NOT NULL,
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tbldiagnosis`
--

INSERT INTO `tbldiagnosis` (`id`, `name`, `shortcode`, `rate`, `dated`) VALUES
(1, 'XRAY', 'XR', 350, '2016-02-14 17:28:26');

-- --------------------------------------------------------

--
-- Table structure for table `tbldocpay`
--

CREATE TABLE IF NOT EXISTS `tbldocpay` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `physicianid` int(7) NOT NULL,
  `pdate` date NOT NULL,
  `pamount` double NOT NULL,
  `dated` date NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `tbldocpay`
--


-- --------------------------------------------------------

--
-- Table structure for table `tbldocument`
--

CREATE TABLE IF NOT EXISTS `tbldocument` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `pid` int(7) NOT NULL,
  `type` varchar(50) NOT NULL,
  `docdata` longblob NOT NULL,
  `dated` datetime NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tbldocument`
--

INSERT INTO `tbldocument` (`id`, `pid`, `type`, `docdata`, `dated`) VALUES
(1, 1, 'XRAYS', 0x89504e470d0a1a0a0000000d49484452000000be000000470806000000b9e9fd4c000000017352474200aece1ce90000000467414d410000b18f0bfc6105000000097048597300000ec300000ec301c76fa8640000001974455874536f6674776172650041646f626520496d616765526561647971c9653c0000165e49444154785eed5d0b745bc59956cac6d6bd7278842674d3c472423840a04d4b488825d90e25d6c379000da1ddb66c97b20dafeef6ec297429ed96b20f0e7bba6577dbb2a5cb526881d20402b4a18e25db0d9087ad97ed04f3088f12422140f3d0d38e13c777bf7faee67aeed5951cd288d86574ce1c4b73e7f1cf37dffcf3ffff8c648743be240212018980444022201190084804240212018980444022201190084804240212018980444022201190084804240212018980444022201190084804240212018980444022201190084804240215474073b89d074e719f2aa6374ea93dad54c7238e998ab5fc6ee4f1f2d66713e1338da9e240cb0ec61702c36add7a4d9da399d3999ae698576527e9b032db52768e764899dd4f65fb51475351b7a83d6bfbe3ebf3b0cbfdf9f1352b529a8a239055eb12489a98f2f83ce0ac735b3b4f9d3c73ea80a52caba7b853bc6c5aa91bc9a8eea18992d2aa7b24afccbab0e240cb0ec6170287d5d926d2f30590aa9e19b44a3a58edaecbd9105f431b2353669c3ebe4626a59108944020afcc9d395282f839c5bdc35a2dabccbed1ba3bd0e7436823afd4ad94404b04260402a9ea3a7f298d4f767a11f155f75e3be20f82fc19a7fb960931e80a0a997f4ab9281b76aecf8495b73361f5cd5cbbba25d3e6bc6b6febd4932bd8ad6cfafd229073d6dd4ca4b523332d8803d5b5b3799b7b1c67b84aed0e053b7f43a9fe077fa7fe7a6893aa89e9f033aa966aab9e2bd6d1922e53195e1ef5359069201351dfcc469407789d7737a8f3b5cde676791d106f0475b228ff5a3aa218bb513ea23c2cca81cf0f162df088faa4555e6d2be4dd58bdd46e8cb98dea05e9b0f2de41c809b26bd9c868ca77a85a1e79b988fa8fbc6ea971529f5ab75aa470deefbccaf263209055dd8fda91dec8536a57f326f2caec85b68e2d5f388a3b59aabbc34f9bc9c08991efa8b9cc44fc2e978934228146ebd02250dfd2d6394eca465c9f20b2d99513f386b1c832edcaf7a9af4c9bf2a0b9fce842a2e723ad8e6a6d4b719b3aa1953bac63d436394e1dec540e8e25c3c8b39061a37229d5d7ca8c9316b2246e8511c828eebe72c44f2beeffe52264d4d97f5bae2c7c8277ecc41d083bbda4dded88018dfcdb72c43fb2c5a569db5cda219b85030dfadd6ca7eb3c91f8c863e529919615fb1cda84bc0ec7c7c7227ea6adea9cc1ce12f246944e9bdd01bb905e1e3b9276185a1be3da9e6d53bb89eca20cb988f2aa1df1f93899ec7d2e49fc0af3de8190e39be5c87cd835db9804ec0ef17265d1d6613b7941825f8a933f80ad9f7fd6a266ed66d584073babcea636d34f393d56cd7e841653d875be989f892869462ccd3129d3aefe48343bc8e480c6fe97b1883fd0a9de6222abb080d0fe9038c63fb6d59c438b8d97a7b1a57eab18a1d15467f599a8f31c523f4b61e5155b8d8f055ce9b996ed0b0880acc3e5c84c61ca9c5afb976cb25c736c7d015e9f7c82bd538b9d3868c1dd864684dd0de7ef49fe994ca04190838b548af8cc448928f78b8424ad9ceb502f302f0825234e30889eb798353f1f8bf8d9b0b2cf30ab407af4bb9d2fa023d0e0036dce59bc8f5c9bf288b8b8a8eda3215891a923897f34b01d9f3259d799e75118b21cf199e3ebacbbf2805a7b41a9e80faf4f65f36aed1a51bad4c38ed3882c02f1df4a45d480484610ebb347437cd4b9e718889f7b3fc44fb557cf11e5256713fec435dcf4c16ea0e5c3caed5c5eec22866dcf1cdb88f32a632ceb1c55fd36c94ee31f08ab9fe265b15b7de4f8ccb06cc516819ceabefaa085f8d8010e152d04d8f9d0fad7142f10f7efc5c32c3aedc509eeff899de5da9db788f632b6fa64ba7dcae91632de7754c4a7dd42342b40c2fdadae4f96d2f8ef6da83a4bb4f399a91376dd594ee36723ce2bc53acc3c79b6661a2d00a36f842849de7570aeb1280ef17c32bda0fd3f6dec0661652fc96697c817b02e622a474e78bacd7993a46c0511c83a6bef66642d24f6dee97e4acca36770807f8fbfeb45e233c22beedbad511eeba11788be934ff0108524a1dd77af752826f320acec2a477c444d9c686397d539465be14c47cd3c13f1c3baa993eb54fd20d7b05887ccaa4cabd3579ef8ea33a6c515763632332baca484fcd799d6866616894f91a04c6bcd343e9674bbfa95b1223dd6e74c4984957fa8e0b4cba641e81d2299198995595f07a1076cb4fe90984766cd807386c7ba63a0ee7b261b3bac0c8ac4cfb5557f15cedfd744e2136146c28ee9762640161a15654d9a9eda836d7f04755cfb6cc29944466b440779da4087c24ea2cb115f4314c9e48f4494af2304792d88ff0ecf3f04edcfc7883cc3d46121db70f567f8b3d4e6534eb3233ec966d5f894478e31b59d8e38bf21d9594104324add1e91cc0741e694327321ed046563fb2807cdfe128966b5fbd166ded0786d55cbad61419a5c31aa43c4a09d2017a95a66477c90f45d2b89511fc4561652f9a2387e581d2c41fade11ec34e5888f38ffa5269306b2d9c97b105a196557b19d25acc64c8e70d8f92d63f7c28e30d0eef4e53a265f60f808187fbaadfa0e3a0c33f939ed5597663b279fb72f3cf97c32052b38edb26968e79c487072740915907f91dd4534b12c7c815b19f11477c6ba6b8c6a4325294eae9590e23384047f6047fcc1d6ea33879f565e228dcd347d21ca32da87f5004b49e73b948f0f0b0e359117ed7f95d729a5f11101faa9c9cc11c2ae1659c964dbca16111c5f715c88d3efb4631637c7d8026853fe4e46754ee0fa2bbaaa50d0d660ff492073d930e77ee79c5a36f16a1dd9ff869f40e6d2d0e439e7b36711c588a8b02d3cacfc8a99353899a464d27838f0b1233ec5f1e99e4bae7df46454279aebe7b61a3f52b0f123d5578bed6b5dacce27ca6afcb07240d4deb90ee737b9ac5679b148dee65307790c738e161916432cdd39c5836b128b7361e7cde2a9ae24fe09243cdba2d5da6556c7940eb318f91c8e49592c8252e60e1d54698e0593198994ba5eb11c39c62967ed5da9b5274f15ed783221a87c7e9332933472be5599898561d8c7fc98be541c3fd5e6fa02453c3831d1f6b096704c2ebeb2301ac787667d5eb0d771925bd0d236571652d859c45356f21398bc116506c9bbb7d571329c4edcfbe127b4ca41630709abff6135e9c8de2779adf7766801a5da9c9fb38e331376be83f4074a38e7387082e9f1e7db3d4c943b6da2374ceb324daa9835b925a233488b432fe76e2b5a204e7702e6c403e289269cd4b8154d10d1d0b02ce2027bb8dc011648f7a8d95954b666379aaf2c40139b0eb0063b46b5310b156e5497d9993a70367f6c0a7db62b45d72f3086cdbc7fd2eca4d10dbc22ea66b2fd4b45716801601165b21dae2fd9ed6ca6dd49ded5a9dcc2b3bfa3e37e9af798aaaebdd1ba3088e064fba36e3b2f97aeaebdc366e7c842031e61b7120b09c4faae75348894ac650742e4f0ea61bcdbb528dda719adc7af2c30b2206e6e753eb158be4579bc0e6cecacd84f7a63d5329333cda24cca7d621fe8f75e1033cef30ae688e93c82ed6e61f547bc0cc90bf97f26f685338b9b919746b921101927d4743b14717edd847a522c6b1da7280f39be959bf90f79cbd0d4a67bf5ccde57dc46fc380153c6ee26262d0690df6f107f4aadc726b233c07784e30d334573f43b377a62874391aab3caf5030ddf29ee3e20e31bc75b2ed9de04410024cf8a26ca10223afb95592b44f161bf17c5f349e38b65b2ae39d38f149ffe0e578af8ccbcc27d7c1e6664b16f9849f936655139e8e11ce7c43ad0ccfb27c8547db062224ebd16e9414ab895780fbe56776d5e715f57817443a6c67d6e4aad5d20b47dc3db351f9b9657606e1ca73e734ef7b7f978e86f5aad1b11893f2c5c4633ec563b3b5fa9fba37526eceef0a08f87c4fe8ee77b985a0f66cfa8fdb598d2a7d73e0eac7e51aa9fec69b31eb3d6c9d5d43d4ce5d1deda4ccd5ce3c4f58365da38ea8d7e5d808840db3a4fb4ed1fef446d0f2a75fb528e99538784f67129ac17570736b0d3d1e394c4b1d8d9eed48f750a20c7e3d6783ecabd5664ababeeb7ac0eaeb5bff1fc999979d5ee8bc711054f8c2819e7ac868c52fb3b6882482513cc8d67f66391a595da7fc5fb70a1af701abf5680fe3756b26f6bdb6967ed1356b4d35573ce826c9b84b21d787f5d513944883e48592bd1172eecb59c18b6c95e250212018980444022201190084804262a028b82dd272f59f9aad6b8fc7996bcc1e49e893a1629b744e0a811685c9a3cd71b4c80f0719688fcb4188eba0159f0b820d0e44f9ce309c45beb0389c78e4b83b291f208789ba3df23c203f4b427181bf1857a346f20be44e2f6c121b0d81fff822fd40bc593d030076b3fb89e3fc43d7902d121467c7fec1e6f2096d7357ff2df44487ccdbd5e5f30b606e906caaf6feebec2138cff98defb02dd7f45cf3cc16e765dc01388dd8c89fc1aafbf607942f505a3d77b82895f60415ddbd4b4c929b6ddd0dc3d9bea7b83dd5fd1dbde3a1d65ef41fbd73b56af3bc96e6a3c7eb4e78fdf517f79dff4c696e4b97afd18ab2fbe20cbd92427cadfddb42cc6ae24f3d7627f72ae2714bfae21a4cb7aa1ff9959287fa72f1435eec77bfdddf3a110beef0b765f518a225e8c15e37ac8dbdc7d8db50cc984fad7352eedc2d5056d523de48446bf8bfae265eb835b3f0dcc7fe60d25f55d37108fd378e607baeac6a26553d3fd4ef47b2deb3f18bdc577458fe9b0cbbbb4cbe7f5c7eec5bcfed013dc62fc62046fd7e78f5dadcf5dfc4cc76db77d04f2dd80c5f7136a9797f186e27f8df6ffa9a925fab1b1e49930cf2f5ad17546e3b27ea669ea5ba28df8bbaf00fe2e711000ef27b413342e7b8e768647e83dfebe4b6500ea2ef639181b04802f78d9fbc43a46e240f43ba4c9d82e823ef4bf5437c1be2c42af86507215cb0f250f8344f7fa5a74cd57e86370f9f2b7545ed6b372cb0cf437e003497c4c3ba24eb0679bde6ed274651624deec0bf5b1b6580af58c6001fcc668ab39f6a5068ca771d9f3dae240f46e5fcb769281f7fb46bd3ffa24d7c2f417ed99bec80145f1398c6388c63b2a6fec806341825d8b66d804937992cd1748b6029341921b799aafa58ff063e70e9e50ec56facc4d4dfacbc6d39cb8bc1c9180c3a3e8fb88de66426bc03cfa9ab779a9ce02c880f9789dcbafcbc7fa30fde814c69bd3e70e4a29941cd4171f61d53bec0d24aec4980f17e606f57bc19124fb9eef847f79fd5dcd3a70f1233a51631b69e08d2b5ed29a566faa31263010bf9b4f8c6e0e819ca1e43e367181f86be649db4ea45ccf9e05e32d4418d4b90ddaef26bc3fc4fc08b40f3f626661e257f1fa05332bd610da3ec0f320d3036c32d7b0c91cd1f3313981c4f398a014f74fd0b6417cbc7f982d0e226c30fe6d7c7e94b7b7b06913d35c58045f2c9001a4a1051d4d10794665c11803b16edebe4ece84cfc024d473503711512610bb71149ff86e6371193b2888d7b23d0dcdd96bf852843176bf7aec98c87fd1f0b302f177f0b98393d88e648b83b17fe6ed34d082f5c79e850c6f8df61bdfcd71827c4f6081eee40b0a18de63940bc672bc1ce47bc713ec7903f3c430282cc61ceaef373009f66c9af0a4671a2990f8219b3c00a07f8e7d966928a691bad96f29eaf902f103b1a1c54ba357c29c6197afccc48fbd5e1f8c5e520f474d0468deeafe2acfd2e885e8ef5705530aa44c5c66253efa6777e3bd81def3d8843292c7d8ef5e92d96290cb1fed61794b9333f4481423a0417cc8cb4c362c9aff618b061ab071f90b7a397f8ced4622f191f7cb421f2b8d3e428947288fb67faef550e7bf5839984f4c41a04d98721f2db477bd8e65fc3008fd1785f6981cb4c03c9e2d530ae50a79a4696162e065b2f1b1a38ad859df3737f7b93836b45b79976e66df38e3af067f6c96a00c5ee4f9dc94c27cede57934ef241fb5477990bb86e304dc47162fdec6be0b0c6c070bb8188bab9c8ce3fe1906c4260100407376f9a0f5ea75b30179a1e47f1aa009c427d3441c98407c0328fe9ca24320df434d2b5e8656dd513075f4e8912f10633f7084adbea0f161baf863c6dd78d2c20cec408c4d5e7d20fef79c941709ce77d38a9d26e2bba1458d3104e37da8bf01e9097ddba7051265df60e2c42f9854dfa43c5fb0671aef83fc1196d71cf736b4ece08e275b206422e85a91ed28eba90f60d9c5ebd2422f1046c73710332ed0018f382b871d892b08981ad87d7493692ce79616bb40eca25f81864dde6c8c41f0b590972c2892112bf1219f711d7a14cff891d5ab35e663617caf729e8c7b528f2560134c0dae2df936c809a3132e3eaa2d04e29336b6233ec03b120cbe5c2d3e437bfdb475d233b417abf7832485b0a91df151e67bbcbe95f8e46718c46fe93a9797b312df178a7b0d4791ec69dac14ca98f693791f82012fbfd7c91f8860d1ee86e30135f9b04390d53acb8fd5e2d186c6538088a85998585bcc49f42fc8b02bd75c6ae14483c609d676f73fc1a6167fc227f0effe9597d9e7b8d4b7f5ce363acecab9df412893fba73e9e62c29c8b17835ee9fd7fb1109294412289489819163bb0f93354c836c5cfe92019068ea1c2df11b41ce06da8ac9b10ac49953c94859383378dfc40f262e3734594bf23ba5884ff97c5c30bbfe9d45669aa39fa2e4f5f7cc5fb4a29bfdaefeb1139f11fa808ed18bd0da5bcfe1edd35f5f30f9498ae01c2bf121b3298e3f178b081af72e5f73d745d4667d73df7443e307e38356a2994cc250ecbf8505a7dbea30038dbc82a9f3a1223e56ef3aab06d0272bdea16fe32c0af06546a463d0f808615ea26b4add01649316883f76ac1a7fb1bf7faab16828c2b0b4fb2a445e7e63e7dc629781e9c6ce2634dd1761449cb430b4c5f8b5e03f85f80dfec44d3c5a84b13dae13499b341336f1222c34816cdc942cabf1996fc5233b8138be9b4bf2ea8b07e380e30b3b1ca61f917edebc7555858004f759369349e9096c69a0f20b96264ee1661de1bfa069d347615e5d25448ed8ef0eb1b9fe30121f60737298bef1033b7b951e5224e730ceb4cfb1109fea41fb19511210e4e0a809626fe3973375981cfef8fd86d6677632d9c57a1442746e1b0289801822845d3f4ce616ed6686362e44750ab6f5fb307574d278437d7b464d8ed888be5326490ee31af5d19a3a0bd6fc7432f941a3634b60c1f64f2d2822a6a9f580438cfdf714dab5c4d3767d612022557074eb9b639f1764a371b3681839d9dcfff850127f917ff3fccf5cb65b6b8239d3b8ec054303704d70f1a5bbd8b38696fe3f30020712f7d1674a17af78c564e37b83bd7bf4765e2cb2f111f775e3f92e8a3e00fc7d6406a0bf41d6f6f2e798b9b264f9cbabf4b67792c37be7a80c6f70195ee679f4776173b4119abc07a9f3ec955ba6709b94cc34b15cc38abed95e7f3446ed52fff4179aaf8f13dfe7efba7ac98ad7b4252b5ec1f61f65bf32ec0bbe3c8d8f1321d51b1939fcdd17eb78ec24c7d8380758b0469b8c31dd0aad3a48ed635c940e61711a877f20e3416acf17da6e7cd11c8be345ca2bf46b60492619c2c0195dd697b0a8bb9aa97fec6adf68828cf5c16ef6ff7af9cbb3323903e6ea363e3e5fcb8ec33e7f72017f5e4f38c11462b2b1b147c3f39b7a4f15db80bc795dbe5e23d273c9e57b58ff4d984f6ee3c3647d9dcd59e839c34c12db91ef4b204031f84a8043a4e4e6143422fbc154eb8b42991402ac44ffbccda6a6fe1aeb89f4b1f64721456b5d6bd0c0fa7cf1157ad8d1eeb51c27e79cc0c72a93ac778211c0b1fc97a175b722dd4d07313817608748ba1990f89b132c9eec5e22501904605abc62b2f1d9e1cb0e72623756a647d9aa44601c20009bd6e30946d743bb6f01d9bbc89184ed1a1807a24911240212018980444022201190084804240212018980444022201190084804240212018980444022201190084804240212018980444022201190084804260602ff0f6c089d57afc9a0a20000000049454e44ae426082, '2016-02-14 16:10:49');
INSERT INTO `tbldocument` (`id`, `pid`, `type`, `docdata`, `dated`) VALUES

-- --------------------------------------------------------

--
-- Table structure for table `tblinvoice`
--

CREATE TABLE IF NOT EXISTS `tblinvoice` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `patientid` int(7) NOT NULL,
  `tokenid` int(7) NOT NULL,
  `amount` double NOT NULL,
  `dated` datetime NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `tblinvoice`
--


-- --------------------------------------------------------

--
-- Table structure for table `tblmedicine`
--

CREATE TABLE IF NOT EXISTS `tblmedicine` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `dated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `tblmedicine`
--


-- --------------------------------------------------------

--
-- Table structure for table `tblpatient`
--

CREATE TABLE IF NOT EXISTS `tblpatient` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` varchar(10) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `married` varchar(50) NOT NULL,
  `bloodgroup` varchar(50) NOT NULL,
  `height` double NOT NULL,
  `weight` double NOT NULL,
  `financialstatus` varchar(50) NOT NULL,
  `account` varchar(20) NOT NULL,
  `dated` date NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `tblpatient`
--

INSERT INTO `tblpatient` (`id`, `name`, `age`, `contact`, `married`, `bloodgroup`, `height`, `weight`, `financialstatus`, `account`, `dated`) VALUES
(1, 'amit', '25', '8585858585', 'Married', 'O', 170, 85, 'Strong', '2585858578', '2016-02-14'),
(2, 'Avi', '45', '854522522', 'Married', 'O', 145, 49, 'Strong', '2452145215', '2016-02-14'),
(3, 'Ddlj', '35', '94313514684', 'Married', 'o', 124, 21, 'Strong', '35416884', '2016-02-14');

-- --------------------------------------------------------

--
-- Table structure for table `tblpatientdiagnosis`
--

CREATE TABLE IF NOT EXISTS `tblpatientdiagnosis` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `patientid` int(7) NOT NULL,
  `diagnosisid` int(7) NOT NULL,
  `physicianid` int(7) NOT NULL,
  `status` varchar(50) NOT NULL,
  `detail` varchar(1000) NOT NULL,
  `dated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tblpatientdiagnosis`
--

INSERT INTO `tblpatientdiagnosis` (`id`, `patientid`, `diagnosisid`, `physicianid`, `status`, `detail`, `dated`) VALUES
(1, 1, 1, 1, 'Active-improving', 'Very good improvement', '2016-02-14 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tblpayment`
--

CREATE TABLE IF NOT EXISTS `tblpayment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `pid` int(7) NOT NULL,
  `pname` varchar(100) NOT NULL,
  `ptype` varchar(20) NOT NULL,
  `torp` int(7) NOT NULL,
  `amount` double NOT NULL,
  `recieved` double NOT NULL,
  `status` varchar(10) NOT NULL,
  `dated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tblpayment`
--

INSERT INTO `tblpayment` (`id`, `pid`, `pname`, `ptype`, `torp`, `amount`, `recieved`, `status`, `dated`) VALUES
(1, 1, 'amit', 'Appointment', 7, 250, 250, 'Recieved', '2016-02-15 23:01:41'),
(2, 1, 'amit', 'Appointment', 8, 250, 0, 'Active', '2016-02-15 22:19:51');

-- --------------------------------------------------------

--
-- Table structure for table `tblpharmacyqueue`
--

CREATE TABLE IF NOT EXISTS `tblpharmacyqueue` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `token` int(7) NOT NULL,
  `referedby` int(7) NOT NULL,
  `status` varchar(50) NOT NULL,
  `dated` date NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `tblpharmacyqueue`
--


-- --------------------------------------------------------

--
-- Table structure for table `tblphysician`
--

CREATE TABLE IF NOT EXISTS `tblphysician` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `married` varchar(50) NOT NULL,
  `qualification` varchar(50) NOT NULL,
  `councilreg` varchar(50) NOT NULL,
  `employer` varchar(50) NOT NULL,
  `fees` double NOT NULL,
  `speciality` varchar(50) NOT NULL,
  `bank` varchar(50) NOT NULL,
  `branch` varchar(50) NOT NULL,
  `account` varchar(50) NOT NULL,
  `c1` varchar(20) NOT NULL,
  `c2` varchar(20) NOT NULL,
  `c3` varchar(20) NOT NULL,
  `c4` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `question` varchar(50) NOT NULL,
  `answer` varchar(50) NOT NULL,
  `image` varchar(100) NOT NULL,
  `dated` date NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tblphysician`
--

INSERT INTO `tblphysician` (`id`, `fullname`, `dob`, `address`, `email`, `gender`, `married`, `qualification`, `councilreg`, `employer`, `fees`, `speciality`, `bank`, `branch`, `account`, `c1`, `c2`, `c3`, `c4`, `username`, `password`, `question`, `answer`, `image`, `dated`) VALUES
(1, 'Ajeet Pratap Singh', '1987-07-15', 'Lucknow', 'er.ajeet@live.com', 'Male', 'Married', '1', 'asbjdas', 'APV', 250, '1', 'indusind', 'gomti', '100002505661', '9453699196', '9453699196', '9453699196', '9453699196', 'ajeetaryan', 'ajeetaryan', '....', '....', '', '2016-02-12'),
(2, 'dzgdg', '1988-07-12', 'gf', 'jjjhj', 'Male', 'Married', '2', 'hjkggjg', 'hjghjgh', 456, '2', 'xdgdg', 'dfdfg', '456456', '644546456', '5646456', '456456456', '45645645', 'dfgdgdgd', 'ggdfgdf', '....', '....', '', '2016-02-14');

-- --------------------------------------------------------

--
-- Table structure for table `tblprescription`
--

CREATE TABLE IF NOT EXISTS `tblprescription` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tokenno` int(7) NOT NULL,
  `physicianid` int(7) NOT NULL,
  `detail` varchar(50) NOT NULL,
  `dated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `tblprescription`
--

INSERT INTO `tblprescription` (`id`, `tokenno`, `physicianid`, `detail`, `dated`) VALUES
(1, 1, 1, 'Active', '2016-02-14 00:00:00'),
(2, 4, 2, 'Active', '2016-02-14 00:00:00'),
(3, 4, 2, 'Active', '2016-02-14 00:00:00'),
(4, 4, 2, 'Active', '2016-02-14 00:00:00'),
(5, 4, 2, 'Active', '2016-02-14 22:31:55'),
(6, 2, 1, 'Active', '2016-02-15 14:01:01'),
(7, 6, 1, 'Active', '2016-02-15 21:58:54');

-- --------------------------------------------------------

--
-- Table structure for table `tblprescriptiondetail`
--

CREATE TABLE IF NOT EXISTS `tblprescriptiondetail` (
  `id` int(11) NOT NULL,
  `prescriptionid` int(11) NOT NULL,
  `medicationid` int(11) NOT NULL,
  `take` int(11) NOT NULL,
  `frequency` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unit` int(11) NOT NULL,
  `rate` double NOT NULL,
  `dated` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblprescriptiondetail`
--


-- --------------------------------------------------------

--
-- Table structure for table `tblqualification`
--

CREATE TABLE IF NOT EXISTS `tblqualification` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `qname` varchar(50) NOT NULL,
  `dated` date NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tblqualification`
--

INSERT INTO `tblqualification` (`id`, `qname`, `dated`) VALUES
(1, 'MBBS', '2016-02-12'),
(2, 'BDS', '2016-02-13');

-- --------------------------------------------------------

--
-- Table structure for table `tblspeciality`
--

CREATE TABLE IF NOT EXISTS `tblspeciality` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sname` varchar(50) NOT NULL,
  `dated` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`sname`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tblspeciality`
--

INSERT INTO `tblspeciality` (`id`, `sname`, `dated`) VALUES
(1, 'Orthopedic', '2016-02-12'),
(2, 'Surgeon', '2016-02-13');

-- --------------------------------------------------------

--
-- Table structure for table `tbltoken`
--

CREATE TABLE IF NOT EXISTS `tbltoken` (
  `tid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cid` int(7) NOT NULL,
  `did` int(5) NOT NULL,
  `pid` int(7) NOT NULL,
  `hfee` double NOT NULL,
  `pfee` double NOT NULL,
  `ctoken` varchar(10) NOT NULL DEFAULT 'Active',
  `ptoken` varchar(10) NOT NULL DEFAULT 'Active',
  `btoken` varchar(10) NOT NULL DEFAULT 'Active',
  `dated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  UNIQUE KEY `tid` (`tid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `tbltoken`
--

INSERT INTO `tbltoken` (`tid`, `cid`, `did`, `pid`, `hfee`, `pfee`, `ctoken`, `ptoken`, `btoken`, `dated`) VALUES
(1, 1, 1, 1, 0, 250, 'Active', 'Active', 'Active', '2016-02-14 00:00:00'),
(2, 1, 1, 2, 0, 250, 'Active', 'Active', 'Active', '2016-02-14 00:00:00'),
(3, 1, 1, 2, 0, 250, 'Active', 'Active', 'Active', '2016-02-14 00:00:00'),
(4, 2, 2, 2, 0, 456, 'Active', 'Active', 'Active', '2016-02-14 00:00:00'),
(5, 1, 1, 1, 0, 250, 'Active', 'Active', 'Active', '2016-02-15 00:00:00'),
(6, 1, 1, 1, 0, 250, 'Active', 'Active', 'Active', '2016-02-15 00:00:00'),
(7, 1, 1, 1, 0, 250, 'Active', 'Active', 'Active', '2016-02-15 00:00:00'),
(8, 1, 1, 1, 0, 250, 'Active', 'Active', 'Active', '2016-02-15 22:19:51');

-- --------------------------------------------------------

--
-- Table structure for table `tbluser`
--

CREATE TABLE IF NOT EXISTS `tbluser` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` varchar(20) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `question` varchar(50) NOT NULL,
  `answer` varchar(50) NOT NULL,
  `dated` date NOT NULL,
  `lastlogin` datetime NOT NULL,
  `lastlogout` datetime NOT NULL,
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `tbluser`
--

INSERT INTO `tbluser` (`id`, `username`, `password`, `type`, `fullname`, `question`, `answer`, `dated`, `lastlogin`, `lastlogout`) VALUES
(1, 'superuser', 'superuser', 'Super User', 'Super User', '', '', '2016-02-11', '0000-00-00 00:00:00', '0000-00-00 00:00:00');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;