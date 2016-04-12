/*
 * Copyright (c) 2016 - Alberto Paro All Rights Reserved.
 */


package io.megl.web.icons

import japgolly.scalajs.react.vdom.all._

/**
  * Provides type-safe access to FontAwesome icons
  */

object FontAwesome {
  def apply(name: String): web.Icon = i(cls := s"fa fa-$name")

  def `500px` = apply("500px")

  def adjust = apply("adjust")

  def adn = apply("adn")

  def alignCenter = apply("align-center")

  def alignJustify = apply("align-justify")

  def alignLeft = apply("align-left")

  def alignRight = apply("align-right")

  def amazon = apply("amazon")

  def ambulance = apply("ambulance")

  def anchor = apply("anchor")

  def android = apply("android")

  def angellist = apply("angellist")

  def angleDoubleDown = apply("angle-double-down")

  def angleDoubleLeft = apply("angle-double-left")

  def angleDoubleRight = apply("angle-double-right")

  def angleDoubleUp = apply("angle-double-up")

  def angleDown = apply("angle-down")

  def angleLeft = apply("angle-left")

  def angleRight = apply("angle-right")

  def angleUp = apply("angle-up")

  def apple = apply("apple")

  def archive = apply("archive")

  def areaChart = apply("area-chart")

  def arrowCircleDown = apply("arrow-circle-down")

  def arrowCircleLeft = apply("arrow-circle-left")

  def arrowCircleODown = apply("arrow-circle-o-down")

  def arrowCircleOLeft = apply("arrow-circle-o-left")

  def arrowCircleORight = apply("arrow-circle-o-right")

  def arrowCircleOUp = apply("arrow-circle-o-up")

  def arrowCircleRight = apply("arrow-circle-right")

  def arrowCircleUp = apply("arrow-circle-up")

  def arrowDown = apply("arrow-down")

  def arrowLeft = apply("arrow-left")

  def arrowRight = apply("arrow-right")

  def arrowUp = apply("arrow-up")

  def arrows = apply("arrows")

  def arrowsAlt = apply("arrows-alt")

  def arrowsH = apply("arrows-h")

  def arrowsV = apply("arrows-v")

  def asterisk = apply("asterisk")

  def at = apply("at")

  def automobile = apply("automobile")

  def backward = apply("backward")

  def balanceScale = apply("balance-scale")

  def ban = apply("ban")

  def bank = apply("bank")

  def barChart = apply("bar-chart")

  def barChartO = apply("bar-chart-o")

  def barcode = apply("barcode")

  def bars = apply("bars")

  def battery0 = apply("battery-0")

  def battery1 = apply("battery-1")

  def battery2 = apply("battery-2")

  def battery3 = apply("battery-3")

  def battery4 = apply("battery-4")

  def batteryEmpty = apply("battery-empty")

  def batteryFull = apply("battery-full")

  def batteryHalf = apply("battery-half")

  def batteryQuarter = apply("battery-quarter")

  def batteryThreeQuarters = apply("battery-three-quarters")

  def bed = apply("bed")

  def beer = apply("beer")

  def behance = apply("behance")

  def behanceSquare = apply("behance-square")

  def bell = apply("bell")

  def bellO = apply("bell-o")

  def bellSlash = apply("bell-slash")

  def bellSlashO = apply("bell-slash-o")

  def bicycle = apply("bicycle")

  def binoculars = apply("binoculars")

  def birthdayCake = apply("birthday-cake")

  def bitbucket = apply("bitbucket")

  def bitbucketSquare = apply("bitbucket-square")

  def bitcoin = apply("bitcoin")

  def blackTie = apply("black-tie")

  def bold = apply("bold")

  def bolt = apply("bolt")

  def bomb = apply("bomb")

  def book = apply("book")

  def bookmark = apply("bookmark")

  def bookmarkO = apply("bookmark-o")

  def briefcase = apply("briefcase")

  def btc = apply("btc")

  def bug = apply("bug")

  def building = apply("building")

  def buildingO = apply("building-o")

  def bullhorn = apply("bullhorn")

  def bullseye = apply("bullseye")

  def bus = apply("bus")

  def buysellads = apply("buysellads")

  def cab = apply("cab")

  def calculator = apply("calculator")

  def calendar = apply("calendar")

  def calendarCheckO = apply("calendar-check-o")

  def calendarMinusO = apply("calendar-minus-o")

  def calendarO = apply("calendar-o")

  def calendarPlusO = apply("calendar-plus-o")

  def calendarTimesO = apply("calendar-times-o")

  def camera = apply("camera")

  def cameraRetro = apply("camera-retro")

  def car = apply("car")

  def caretDown = apply("caret-down")

  def caretLeft = apply("caret-left")

  def caretRight = apply("caret-right")

  def caretSquareODown = apply("caret-square-o-down")

  def caretSquareOLeft = apply("caret-square-o-left")

  def caretSquareORight = apply("caret-square-o-right")

  def caretSquareOUp = apply("caret-square-o-up")

  def caretUp = apply("caret-up")

  def cartArrowDown = apply("cart-arrow-down")

  def cartPlus = apply("cart-plus")

  def cc = apply("cc")

  def ccAmex = apply("cc-amex")

  def ccDinersClub = apply("cc-diners-club")

  def ccDiscover = apply("cc-discover")

  def ccJcb = apply("cc-jcb")

  def ccMastercard = apply("cc-mastercard")

  def ccPaypal = apply("cc-paypal")

  def ccStripe = apply("cc-stripe")

  def ccVisa = apply("cc-visa")

  def certificate = apply("certificate")

  def chain = apply("chain")

  def chainBroken = apply("chain-broken")

  def check = apply("check")

  def checkCircle = apply("check-circle")

  def checkCircleO = apply("check-circle-o")

  def checkSquare = apply("check-square")

  def checkSquareO = apply("check-square-o")

  def chevronCircleDown = apply("chevron-circle-down")

  def chevronCircleLeft = apply("chevron-circle-left")

  def chevronCircleRight = apply("chevron-circle-right")

  def chevronCircleUp = apply("chevron-circle-up")

  def chevronDown = apply("chevron-down")

  def chevronLeft = apply("chevron-left")

  def chevronRight = apply("chevron-right")

  def chevronUp = apply("chevron-up")

  def child = apply("child")

  def chrome = apply("chrome")

  def circle = apply("circle")

  def circleO = apply("circle-o")

  def circleONotch = apply("circle-o-notch")

  def circleThin = apply("circle-thin")

  def clipboard = apply("clipboard")

  def clockO = apply("clock-o")

  def clonE = apply("clone")

  def close = apply("close")

  def cloud = apply("cloud")

  def cloudDownload = apply("cloud-download")

  def cloudUpload = apply("cloud-upload")

  def cny = apply("cny")

  def code = apply("code")

  def codeFork = apply("code-fork")

  def codepen = apply("codepen")

  def coffee = apply("coffee")

  def cog = apply("cog")

  def cogs = apply("cogs")

  def columns = apply("columns")

  def comment = apply("comment")

  def commentO = apply("comment-o")

  def commenting = apply("commenting")

  def commentingO = apply("commenting-o")

  def comments = apply("comments")

  def commentsO = apply("comments-o")

  def compass = apply("compass")

  def compress = apply("compress")

  def connectdevelop = apply("connectdevelop")

  def contao = apply("contao")

  def copy = apply("copy")

  def copyright = apply("copyright")

  def creativeCommons = apply("creative-commons")

  def creditCard = apply("credit-card")

  def crop = apply("crop")

  def crosshairs = apply("crosshairs")

  def css3 = apply("css3")

  def cube = apply("cube")

  def cubes = apply("cubes")

  def cut = apply("cut")

  def cutlery = apply("cutlery")

  def dashboard = apply("dashboard")

  def dashcube = apply("dashcube")

  def database = apply("database")

  def dedent = apply("dedent")

  def delicious = apply("delicious")

  def desktop = apply("desktop")

  def deviantart = apply("deviantart")

  def diamond = apply("diamond")

  def digg = apply("digg")

  def dollar = apply("dollar")

  def dotCircleO = apply("dot-circle-o")

  def download = apply("download")

  def dribbble = apply("dribbble")

  def dropbox = apply("dropbox")

  def drupal = apply("drupal")

  def edit = apply("edit")

  def eject = apply("eject")

  def ellipsisH = apply("ellipsis-h")

  def ellipsisV = apply("ellipsis-v")

  def empire = apply("empire")

  def envelope = apply("envelope")

  def envelopeO = apply("envelope-o")

  def envelopeSquare = apply("envelope-square")

  def eraser = apply("eraser")

  def eur = apply("eur")

  def euro = apply("euro")

  def exchange = apply("exchange")

  def exclamation = apply("exclamation")

  def exclamationCircle = apply("exclamation-circle")

  def exclamationTriangle = apply("exclamation-triangle")

  def expand = apply("expand")

  def expeditedssl = apply("expeditedssl")

  def externalLink = apply("external-link")

  def externalLinkSquare = apply("external-link-square")

  def eye = apply("eye")

  def eyeSlash = apply("eye-slash")

  def eyedropper = apply("eyedropper")

  def facebook = apply("facebook")

  def facebookF = apply("facebook-f")

  def facebookOfficial = apply("facebook-official")

  def facebookSquare = apply("facebook-square")

  def fastBackward = apply("fast-backward")

  def fastForward = apply("fast-forward")

  def fax = apply("fax")

  def feed = apply("feed")

  def female = apply("female")

  def fighterJet = apply("fighter-jet")

  def file = apply("file")

  def fileArchiveO = apply("file-archive-o")

  def fileAudioO = apply("file-audio-o")

  def fileCodeO = apply("file-code-o")

  def fileExcelO = apply("file-excel-o")

  def fileImageO = apply("file-image-o")

  def fileMovieO = apply("file-movie-o")

  def fileO = apply("file-o")

  def filePdfO = apply("file-pdf-o")

  def filePhotoO = apply("file-photo-o")

  def filePictureO = apply("file-picture-o")

  def filePowerpointO = apply("file-powerpoint-o")

  def fileSoundO = apply("file-sound-o")

  def fileText = apply("file-text")

  def fileTextO = apply("file-text-o")

  def fileVideoO = apply("file-video-o")

  def fileWordO = apply("file-word-o")

  def fileZipO = apply("file-zip-o")

  def filesO = apply("files-o")

  def film = apply("film")

  def filter = apply("filter")

  def fire = apply("fire")

  def fireExtinguisher = apply("fire-extinguisher")

  def firefox = apply("firefox")

  def flag = apply("flag")

  def flagCheckered = apply("flag-checkered")

  def flagO = apply("flag-o")

  def flash = apply("flash")

  def flask = apply("flask")

  def flickr = apply("flickr")

  def floppyO = apply("floppy-o")

  def folder = apply("folder")

  def folderO = apply("folder-o")

  def folderOpen = apply("folder-open")

  def folderOpenO = apply("folder-open-o")

  def font = apply("font")

  def fonticons = apply("fonticons")

  def forumbee = apply("forumbee")

  def forward = apply("forward")

  def foursquare = apply("foursquare")

  def frownO = apply("frown-o")

  def futbolO = apply("futbol-o")

  def gamepad = apply("gamepad")

  def gavel = apply("gavel")

  def gbp = apply("gbp")

  def ge = apply("ge")

  def gear = apply("gear")

  def gears = apply("gears")

  def genderless = apply("genderless")

  def getPocket = apply("get-pocket")

  def gg = apply("gg")

  def ggCircle = apply("gg-circle")

  def gift = apply("gift")

  def git = apply("git")

  def gitSquare = apply("git-square")

  def github = apply("github")

  def githubAlt = apply("github-alt")

  def githubSquare = apply("github-square")

  def gittip = apply("gittip")

  def glass = apply("glass")

  def globe = apply("globe")

  def google = apply("google")

  def googlePlus = apply("google-plus")

  def googlePlusSquare = apply("google-plus-square")

  def googleWallet = apply("google-wallet")

  def graduationCap = apply("graduation-cap")

  def gratipay = apply("gratipay")

  def group = apply("group")

  def hSquare = apply("h-square")

  def hackerNews = apply("hacker-news")

  def handGrabO = apply("hand-grab-o")

  def handLizardO = apply("hand-lizard-o")

  def handODown = apply("hand-o-down")

  def handOLeft = apply("hand-o-left")

  def handORight = apply("hand-o-right")

  def handOUp = apply("hand-o-up")

  def handPaperO = apply("hand-paper-o")

  def handPeaceO = apply("hand-peace-o")

  def handPointerO = apply("hand-pointer-o")

  def handRockO = apply("hand-rock-o")

  def handScissorsO = apply("hand-scissors-o")

  def handSpockO = apply("hand-spock-o")

  def handStopO = apply("hand-stop-o")

  def hddO = apply("hdd-o")

  def header = apply("header")

  def headphones = apply("headphones")

  def heart = apply("heart")

  def heartO = apply("heart-o")

  def heartbeat = apply("heartbeat")

  def history = apply("history")

  def home = apply("home")

  def hospitalO = apply("hospital-o")

  def hotel = apply("hotel")

  def hourglass = apply("hourglass")

  def hourglass1 = apply("hourglass-1")

  def hourglass2 = apply("hourglass-2")

  def hourglass3 = apply("hourglass-3")

  def hourglassEnd = apply("hourglass-end")

  def hourglassHalf = apply("hourglass-half")

  def hourglassO = apply("hourglass-o")

  def hourglassStart = apply("hourglass-start")

  def houzz = apply("houzz")

  def html5 = apply("html5")

  def iCursor = apply("i-cursor")

  def ils = apply("ils")

  def image = apply("image")

  def inbox = apply("inbox")

  def indent = apply("indent")

  def industry = apply("industry")

  def info = apply("info")

  def infoCircle = apply("info-circle")

  def inr = apply("inr")

  def instagram = apply("instagram")

  def institution = apply("institution")

  def internetExplorer = apply("internet-explorer")

  def intersex = apply("intersex")

  def ioxhost = apply("ioxhost")

  def italic = apply("italic")

  def joomla = apply("joomla")

  def jpy = apply("jpy")

  def jsfiddle = apply("jsfiddle")

  def key = apply("key")

  def keyboardO = apply("keyboard-o")

  def krw = apply("krw")

  def language = apply("language")

  def laptop = apply("laptop")

  def lastfm = apply("lastfm")

  def lastfmSquare = apply("lastfm-square")

  def leaf = apply("leaf")

  def leanpub = apply("leanpub")

  def legal = apply("legal")

  def lemonO = apply("lemon-o")

  def levelDown = apply("level-down")

  def levelUp = apply("level-up")

  def lifeBouy = apply("life-bouy")

  def lifeBuoy = apply("life-buoy")

  def lifeRing = apply("life-ring")

  def lifeSaver = apply("life-saver")

  def lightbulbO = apply("lightbulb-o")

  def lineChart = apply("line-chart")

  def link = apply("link")

  def linkedin = apply("linkedin")

  def linkedinSquare = apply("linkedin-square")

  def linux = apply("linux")

  def list = apply("list")

  def listAlt = apply("list-alt")

  def listOl = apply("list-ol")

  def listUl = apply("list-ul")

  def locationArrow = apply("location-arrow")

  def lock = apply("lock")

  def longArrowDown = apply("long-arrow-down")

  def longArrowLeft = apply("long-arrow-left")

  def longArrowRight = apply("long-arrow-right")

  def longArrowUp = apply("long-arrow-up")

  def magic = apply("magic")

  def magnet = apply("magnet")

  def mailForward = apply("mail-forward")

  def mailReply = apply("mail-reply")

  def mailReplyAll = apply("mail-reply-all")

  def male = apply("male")

  def map = apply("map")

  def mapMarker = apply("map-marker")

  def mapO = apply("map-o")

  def mapPin = apply("map-pin")

  def mapSigns = apply("map-signs")

  def mars = apply("mars")

  def marsDouble = apply("mars-double")

  def marsStroke = apply("mars-stroke")

  def marsStrokeH = apply("mars-stroke-h")

  def marsStrokeV = apply("mars-stroke-v")

  def maxcdn = apply("maxcdn")

  def meanpath = apply("meanpath")

  def medium = apply("medium")

  def medkit = apply("medkit")

  def mehO = apply("meh-o")

  def mercury = apply("mercury")

  def microphone = apply("microphone")

  def microphoneSlash = apply("microphone-slash")

  def minus = apply("minus")

  def minusCircle = apply("minus-circle")

  def minusSquare = apply("minus-square")

  def minusSquareO = apply("minus-square-o")

  def mobile = apply("mobile")

  def mobilePhone = apply("mobile-phone")

  def money = apply("money")

  def moonO = apply("moon-o")

  def mortarBoard = apply("mortar-board")

  def motorcycle = apply("motorcycle")

  def mousePointer = apply("mouse-pointer")

  def music = apply("music")

  def navicon = apply("navicon")

  def neuter = apply("neuter")

  def newspaperO = apply("newspaper-o")

  def objectGroup = apply("object-group")

  def objectUngroup = apply("object-ungroup")

  def odnoklassniki = apply("odnoklassniki")

  def odnoklassnikiSquare = apply("odnoklassniki-square")

  def opencart = apply("opencart")

  def openid = apply("openid")

  def opera = apply("opera")

  def optinMonster = apply("optin-monster")

  def outdent = apply("outdent")

  def pagelines = apply("pagelines")

  def paintBrush = apply("paint-brush")

  def paperPlane = apply("paper-plane")

  def paperPlaneO = apply("paper-plane-o")

  def paperclip = apply("paperclip")

  def paragraph = apply("paragraph")

  def paste = apply("paste")

  def pause = apply("pause")

  def paw = apply("paw")

  def paypal = apply("paypal")

  def pencil = apply("pencil")

  def pencilSquare = apply("pencil-square")

  def pencilSquareO = apply("pencil-square-o")

  def phone = apply("phone")

  def phoneSquare = apply("phone-square")

  def photo = apply("photo")

  def pictureO = apply("picture-o")

  def pieChart = apply("pie-chart")

  def piedPiper = apply("pied-piper")

  def piedPiperAlt = apply("pied-piper-alt")

  def pinterest = apply("pinterest")

  def pinterestP = apply("pinterest-p")

  def pinterestSquare = apply("pinterest-square")

  def plane = apply("plane")

  def play = apply("play")

  def playCircle = apply("play-circle")

  def playCircleO = apply("play-circle-o")

  def plug = apply("plug")

  def plus = apply("plus")

  def plusCircle = apply("plus-circle")

  def plusSquare = apply("plus-square")

  def plusSquareO = apply("plus-square-o")

  def powerOff = apply("power-off")

  def print = apply("print")

  def puzzlePiece = apply("puzzle-piece")

  def qq = apply("qq")

  def qrcode = apply("qrcode")

  def question = apply("question")

  def questionCircle = apply("question-circle")

  def quoteLeft = apply("quote-left")

  def quoteRight = apply("quote-right")

  def ra = apply("ra")

  def random = apply("random")

  def rebel = apply("rebel")

  def recycle = apply("recycle")

  def reddit = apply("reddit")

  def redditSquare = apply("reddit-square")

  def refresh = apply("refresh")

  def registered = apply("registered")

  def remove = apply("remove")

  def renren = apply("renren")

  def reorder = apply("reorder")

  def repeat = apply("repeat")

  def reply = apply("reply")

  def replyAll = apply("reply-all")

  def retweet = apply("retweet")

  def rmb = apply("rmb")

  def road = apply("road")

  def rocket = apply("rocket")

  def rotateLeft = apply("rotate-left")

  def rotateRight = apply("rotate-right")

  def rouble = apply("rouble")

  def rss = apply("rss")

  def rssSquare = apply("rss-square")

  def rub = apply("rub")

  def ruble = apply("ruble")

  def rupee = apply("rupee")

  def safari = apply("safari")

  def save = apply("save")

  def scissors = apply("scissors")

  def search = apply("search")

  def searchMinus = apply("search-minus")

  def searchPlus = apply("search-plus")

  def sellsy = apply("sellsy")

  def send = apply("send")

  def sendO = apply("send-o")

  def server = apply("server")

  def share = apply("share")

  def shareAlt = apply("share-alt")

  def shareAltSquare = apply("share-alt-square")

  def shareSquare = apply("share-square")

  def shareSquareO = apply("share-square-o")

  def shekel = apply("shekel")

  def sheqel = apply("sheqel")

  def shield = apply("shield")

  def ship = apply("ship")

  def shirtsinbulk = apply("shirtsinbulk")

  def shoppingCart = apply("shopping-cart")

  def signIn = apply("sign-in")

  def signOut = apply("sign-out")

  def signal = apply("signal")

  def simplybuilt = apply("simplybuilt")

  def sitemap = apply("sitemap")

  def skyatlas = apply("skyatlas")

  def skype = apply("skype")

  def slack = apply("slack")

  def sliders = apply("sliders")

  def slideshare = apply("slideshare")

  def smileO = apply("smile-o")

  def soccerBallO = apply("soccer-ball-o")

  def sort = apply("sort")

  def sortAlphaAsc = apply("sort-alpha-asc")

  def sortAlphaDesc = apply("sort-alpha-desc")

  def sortAmountAsc = apply("sort-amount-asc")

  def sortAmountDesc = apply("sort-amount-desc")

  def sortAsc = apply("sort-asc")

  def sortDesc = apply("sort-desc")

  def sortDown = apply("sort-down")

  def sortNumericAsc = apply("sort-numeric-asc")

  def sortNumericDesc = apply("sort-numeric-desc")

  def sortUp = apply("sort-up")

  def soundcloud = apply("soundcloud")

  def spaceShuttle = apply("space-shuttle")

  def spinner = apply("spinner")

  def spoon = apply("spoon")

  def spotify = apply("spotify")

  def square = apply("square")

  def squareO = apply("square-o")

  def stackExchange = apply("stack-exchange")

  def stackOverflow = apply("stack-overflow")

  def star = apply("star")

  def starHalf = apply("star-half")

  def starHalfEmpty = apply("star-half-empty")

  def starHalfFull = apply("star-half-full")

  def starHalfO = apply("star-half-o")

  def starO = apply("star-o")

  def steam = apply("steam")

  def steamSquare = apply("steam-square")

  def stepBackward = apply("step-backward")

  def stepForward = apply("step-forward")

  def stethoscope = apply("stethoscope")

  def stickyNote = apply("sticky-note")

  def stickyNoteO = apply("sticky-note-o")

  def stop = apply("stop")

  def streetView = apply("street-view")

  def strikethrough = apply("strikethrough")

  def stumbleupon = apply("stumbleupon")

  def stumbleuponCircle = apply("stumbleupon-circle")

  def subscript = apply("subscript")

  def subway = apply("subway")

  def suitcase = apply("suitcase")

  def sunO = apply("sun-o")

  def superscript = apply("superscript")

  def support = apply("support")

  def table = apply("table")

  def tablet = apply("tablet")

  def tachometer = apply("tachometer")

  def tag = apply("tag")

  def tags = apply("tags")

  def tasks = apply("tasks")

  def taxi = apply("taxi")

  def television = apply("television")

  def tencentWeibo = apply("tencent-weibo")

  def terminal = apply("terminal")

  def textHeight = apply("text-height")

  def textWidth = apply("text-width")

  def th = apply("th")

  def thLarge = apply("th-large")

  def thList = apply("th-list")

  def thumbTack = apply("thumb-tack")

  def thumbsDown = apply("thumbs-down")

  def thumbsODown = apply("thumbs-o-down")

  def thumbsOUp = apply("thumbs-o-up")

  def thumbsUp = apply("thumbs-up")

  def ticket = apply("ticket")

  def times = apply("times")

  def timesCircle = apply("times-circle")

  def timesCircleO = apply("times-circle-o")

  def tint = apply("tint")

  def toggleDown = apply("toggle-down")

  def toggleLeft = apply("toggle-left")

  def toggleOff = apply("toggle-off")

  def toggleOn = apply("toggle-on")

  def toggleRight = apply("toggle-right")

  def toggleUp = apply("toggle-up")

  def trademark = apply("trademark")

  def train = apply("train")

  def transgender = apply("transgender")

  def transgenderAlt = apply("transgender-alt")

  def trash = apply("trash")

  def trashO = apply("trash-o")

  def tree = apply("tree")

  def trello = apply("trello")

  def tripadvisor = apply("tripadvisor")

  def trophy = apply("trophy")

  def truck = apply("truck")

  def trY = apply("try")

  def tty = apply("tty")

  def tumblr = apply("tumblr")

  def tumblrSquare = apply("tumblr-square")

  def turkishLira = apply("turkish-lira")

  def tv = apply("tv")

  def twitch = apply("twitch")

  def twitter = apply("twitter")

  def twitterSquare = apply("twitter-square")

  def umbrella = apply("umbrella")

  def underline = apply("underline")

  def undo = apply("undo")

  def university = apply("university")

  def unlink = apply("unlink")

  def unlock = apply("unlock")

  def unlockAlt = apply("unlock-alt")

  def unsorted = apply("unsorted")

  def upload = apply("upload")

  def usd = apply("usd")

  def user = apply("user")

  def userMd = apply("user-md")

  def userPlus = apply("user-plus")

  def userSecret = apply("user-secret")

  def userTimes = apply("user-times")

  def users = apply("users")

  def venus = apply("venus")

  def venusDouble = apply("venus-double")

  def venusMars = apply("venus-mars")

  def viacoin = apply("viacoin")

  def videoCamera = apply("video-camera")

  def vimeo = apply("vimeo")

  def vimeoSquare = apply("vimeo-square")

  def vine = apply("vine")

  def vk = apply("vk")

  def volumeDown = apply("volume-down")

  def volumeOff = apply("volume-off")

  def volumeUp = apply("volume-up")

  def warning = apply("warning")

  def wechat = apply("wechat")

  def weibo = apply("weibo")

  def weixin = apply("weixin")

  def whatsapp = apply("whatsapp")

  def wheelchair = apply("wheelchair")

  def wifi = apply("wifi")

  def wikipediaW = apply("wikipedia-w")

  def windows = apply("windows")

  def won = apply("won")

  def wordpress = apply("wordpress")

  def wrench = apply("wrench")

  def xing = apply("xing")

  def xingSquare = apply("xing-square")

  def yCombinator = apply("y-combinator")

  def yCombinatorSquare = apply("y-combinator-square")

  def yahoo = apply("yahoo")

  def yc = apply("yc")

  def ycSquare = apply("yc-square")

  def yelp = apply("yelp")

  def yen = apply("yen")

  def youtube = apply("youtube")

  def youtubePlay = apply("youtube-play")

  def youtubeSquare = apply("youtube-square")

  def entries = List("fa fa-500px", "fa fa-adjust", "fa fa-adn", "fa fa-align-center", "fa fa-align-justify", "fa fa-align-left", "fa fa-align-right", "fa fa-amazon", "fa fa-ambulance", "fa fa-anchor", "fa fa-android", "fa fa-angellist", "fa fa-angle-double-down", "fa fa-angle-double-left", "fa fa-angle-double-right", "fa fa-angle-double-up", "fa fa-angle-down", "fa fa-angle-left", "fa fa-angle-right", "fa fa-angle-up", "fa fa-apple", "fa fa-archive", "fa fa-area-chart", "fa fa-arrow-circle-down", "fa fa-arrow-circle-left", "fa fa-arrow-circle-o-down", "fa fa-arrow-circle-o-left", "fa fa-arrow-circle-o-right", "fa fa-arrow-circle-o-up", "fa fa-arrow-circle-right", "fa fa-arrow-circle-up", "fa fa-arrow-down", "fa fa-arrow-left", "fa fa-arrow-right", "fa fa-arrow-up", "fa fa-arrows", "fa fa-arrows-alt", "fa fa-arrows-h", "fa fa-arrows-v", "fa fa-asterisk", "fa fa-at", "fa fa-automobile", "fa fa-backward", "fa fa-balance-scale", "fa fa-ban", "fa fa-bank", "fa fa-bar-chart", "fa fa-bar-chart-o", "fa fa-barcode", "fa fa-bars", "fa fa-battery-0", "fa fa-battery-1", "fa fa-battery-2", "fa fa-battery-3", "fa fa-battery-4", "fa fa-battery-empty", "fa fa-battery-full", "fa fa-battery-half", "fa fa-battery-quarter", "fa fa-battery-three-quarters", "fa fa-bed", "fa fa-beer", "fa fa-behance", "fa fa-behance-square", "fa fa-bell", "fa fa-bell-o", "fa fa-bell-slash", "fa fa-bell-slash-o", "fa fa-bicycle", "fa fa-binoculars", "fa fa-birthday-cake", "fa fa-bitbucket", "fa fa-bitbucket-square", "fa fa-bitcoin", "fa fa-black-tie", "fa fa-bold", "fa fa-bolt", "fa fa-bomb", "fa fa-book", "fa fa-bookmark", "fa fa-bookmark-o", "fa fa-briefcase", "fa fa-btc", "fa fa-bug", "fa fa-building", "fa fa-building-o", "fa fa-bullhorn", "fa fa-bullseye", "fa fa-bus", "fa fa-buysellads", "fa fa-cab", "fa fa-calculator", "fa fa-calendar", "fa fa-calendar-check-o", "fa fa-calendar-minus-o", "fa fa-calendar-o", "fa fa-calendar-plus-o", "fa fa-calendar-times-o", "fa fa-camera", "fa fa-camera-retro", "fa fa-car", "fa fa-caret-down", "fa fa-caret-left", "fa fa-caret-right", "fa fa-caret-square-o-down", "fa fa-caret-square-o-left", "fa fa-caret-square-o-right", "fa fa-caret-square-o-up", "fa fa-caret-up", "fa fa-cart-arrow-down", "fa fa-cart-plus", "fa fa-cc", "fa fa-cc-amex", "fa fa-cc-diners-club", "fa fa-cc-discover", "fa fa-cc-jcb", "fa fa-cc-mastercard", "fa fa-cc-paypal", "fa fa-cc-stripe", "fa fa-cc-visa", "fa fa-certificate", "fa fa-chain", "fa fa-chain-broken", "fa fa-check", "fa fa-check-circle", "fa fa-check-circle-o", "fa fa-check-square", "fa fa-check-square-o", "fa fa-chevron-circle-down", "fa fa-chevron-circle-left", "fa fa-chevron-circle-right", "fa fa-chevron-circle-up", "fa fa-chevron-down", "fa fa-chevron-left", "fa fa-chevron-right", "fa fa-chevron-up", "fa fa-child", "fa fa-chrome", "fa fa-circle", "fa fa-circle-o", "fa fa-circle-o-notch", "fa fa-circle-thin", "fa fa-clipboard", "fa fa-clock-o", "fa fa-clone", "fa fa-close", "fa fa-cloud", "fa fa-cloud-download", "fa fa-cloud-upload", "fa fa-cny", "fa fa-code", "fa fa-code-fork", "fa fa-codepen", "fa fa-coffee", "fa fa-cog", "fa fa-cogs", "fa fa-columns", "fa fa-comment", "fa fa-comment-o", "fa fa-commenting", "fa fa-commenting-o", "fa fa-comments", "fa fa-comments-o", "fa fa-compass", "fa fa-compress", "fa fa-connectdevelop", "fa fa-contao", "fa fa-copy", "fa fa-copyright", "fa fa-creative-commons", "fa fa-credit-card", "fa fa-crop", "fa fa-crosshairs", "fa fa-css3", "fa fa-cube", "fa fa-cubes", "fa fa-cut", "fa fa-cutlery", "fa fa-dashboard", "fa fa-dashcube", "fa fa-database", "fa fa-dedent", "fa fa-delicious", "fa fa-desktop", "fa fa-deviantart", "fa fa-diamond", "fa fa-digg", "fa fa-dollar", "fa fa-dot-circle-o", "fa fa-download", "fa fa-dribbble", "fa fa-dropbox", "fa fa-drupal", "fa fa-edit", "fa fa-eject", "fa fa-ellipsis-h", "fa fa-ellipsis-v", "fa fa-empire", "fa fa-envelope", "fa fa-envelope-o", "fa fa-envelope-square", "fa fa-eraser", "fa fa-eur", "fa fa-euro", "fa fa-exchange", "fa fa-exclamation", "fa fa-exclamation-circle", "fa fa-exclamation-triangle", "fa fa-expand", "fa fa-expeditedssl", "fa fa-external-link", "fa fa-external-link-square", "fa fa-eye", "fa fa-eye-slash", "fa fa-eyedropper", "fa fa-facebook", "fa fa-facebook-f", "fa fa-facebook-official", "fa fa-facebook-square", "fa fa-fast-backward", "fa fa-fast-forward", "fa fa-fax", "fa fa-feed", "fa fa-female", "fa fa-fighter-jet", "fa fa-file", "fa fa-file-archive-o", "fa fa-file-audio-o", "fa fa-file-code-o", "fa fa-file-excel-o", "fa fa-file-image-o", "fa fa-file-movie-o", "fa fa-file-o", "fa fa-file-pdf-o", "fa fa-file-photo-o", "fa fa-file-picture-o", "fa fa-file-powerpoint-o", "fa fa-file-sound-o", "fa fa-file-text", "fa fa-file-text-o", "fa fa-file-video-o", "fa fa-file-word-o", "fa fa-file-zip-o", "fa fa-files-o", "fa fa-film", "fa fa-filter", "fa fa-fire", "fa fa-fire-extinguisher", "fa fa-firefox", "fa fa-flag", "fa fa-flag-checkered", "fa fa-flag-o", "fa fa-flash", "fa fa-flask", "fa fa-flickr", "fa fa-floppy-o", "fa fa-folder", "fa fa-folder-o", "fa fa-folder-open", "fa fa-folder-open-o", "fa fa-font", "fa fa-fonticons", "fa fa-forumbee", "fa fa-forward", "fa fa-foursquare", "fa fa-frown-o", "fa fa-futbol-o", "fa fa-gamepad", "fa fa-gavel", "fa fa-gbp", "fa fa-ge", "fa fa-gear", "fa fa-gears", "fa fa-genderless", "fa fa-get-pocket", "fa fa-gg", "fa fa-gg-circle", "fa fa-gift", "fa fa-git", "fa fa-git-square", "fa fa-github", "fa fa-github-alt", "fa fa-github-square", "fa fa-gittip", "fa fa-glass", "fa fa-globe", "fa fa-google", "fa fa-google-plus", "fa fa-google-plus-square", "fa fa-google-wallet", "fa fa-graduation-cap", "fa fa-gratipay", "fa fa-group", "fa fa-h-square", "fa fa-hacker-news", "fa fa-hand-grab-o", "fa fa-hand-lizard-o", "fa fa-hand-o-down", "fa fa-hand-o-left", "fa fa-hand-o-right", "fa fa-hand-o-up", "fa fa-hand-paper-o", "fa fa-hand-peace-o", "fa fa-hand-pointer-o", "fa fa-hand-rock-o", "fa fa-hand-scissors-o", "fa fa-hand-spock-o", "fa fa-hand-stop-o", "fa fa-hdd-o", "fa fa-header", "fa fa-headphones", "fa fa-heart", "fa fa-heart-o", "fa fa-heartbeat", "fa fa-history", "fa fa-home", "fa fa-hospital-o", "fa fa-hotel", "fa fa-hourglass", "fa fa-hourglass-1", "fa fa-hourglass-2", "fa fa-hourglass-3", "fa fa-hourglass-end", "fa fa-hourglass-half", "fa fa-hourglass-o", "fa fa-hourglass-start", "fa fa-houzz", "fa fa-html5", "fa fa-i-cursor", "fa fa-ils", "fa fa-image", "fa fa-inbox", "fa fa-indent", "fa fa-industry", "fa fa-info", "fa fa-info-circle", "fa fa-inr", "fa fa-instagram", "fa fa-institution", "fa fa-internet-explorer", "fa fa-intersex", "fa fa-ioxhost", "fa fa-italic", "fa fa-joomla", "fa fa-jpy", "fa fa-jsfiddle", "fa fa-key", "fa fa-keyboard-o", "fa fa-krw", "fa fa-language", "fa fa-laptop", "fa fa-lastfm", "fa fa-lastfm-square", "fa fa-leaf", "fa fa-leanpub", "fa fa-legal", "fa fa-lemon-o", "fa fa-level-down", "fa fa-level-up", "fa fa-life-bouy", "fa fa-life-buoy", "fa fa-life-ring", "fa fa-life-saver", "fa fa-lightbulb-o", "fa fa-line-chart", "fa fa-link", "fa fa-linkedin", "fa fa-linkedin-square", "fa fa-linux", "fa fa-list", "fa fa-list-alt", "fa fa-list-ol", "fa fa-list-ul", "fa fa-location-arrow", "fa fa-lock", "fa fa-long-arrow-down", "fa fa-long-arrow-left", "fa fa-long-arrow-right", "fa fa-long-arrow-up", "fa fa-magic", "fa fa-magnet", "fa fa-mail-forward", "fa fa-mail-reply", "fa fa-mail-reply-all", "fa fa-male", "fa fa-map", "fa fa-map-marker", "fa fa-map-o", "fa fa-map-pin", "fa fa-map-signs", "fa fa-mars", "fa fa-mars-double", "fa fa-mars-stroke", "fa fa-mars-stroke-h", "fa fa-mars-stroke-v", "fa fa-maxcdn", "fa fa-meanpath", "fa fa-medium", "fa fa-medkit", "fa fa-meh-o", "fa fa-mercury", "fa fa-microphone", "fa fa-microphone-slash", "fa fa-minus", "fa fa-minus-circle", "fa fa-minus-square", "fa fa-minus-square-o", "fa fa-mobile", "fa fa-mobile-phone", "fa fa-money", "fa fa-moon-o", "fa fa-mortar-board", "fa fa-motorcycle", "fa fa-mouse-pointer", "fa fa-music", "fa fa-navicon", "fa fa-neuter", "fa fa-newspaper-o", "fa fa-object-group", "fa fa-object-ungroup", "fa fa-odnoklassniki", "fa fa-odnoklassniki-square", "fa fa-opencart", "fa fa-openid", "fa fa-opera", "fa fa-optin-monster", "fa fa-outdent", "fa fa-pagelines", "fa fa-paint-brush", "fa fa-paper-plane", "fa fa-paper-plane-o", "fa fa-paperclip", "fa fa-paragraph", "fa fa-paste", "fa fa-pause", "fa fa-paw", "fa fa-paypal", "fa fa-pencil", "fa fa-pencil-square", "fa fa-pencil-square-o", "fa fa-phone", "fa fa-phone-square", "fa fa-photo", "fa fa-picture-o", "fa fa-pie-chart", "fa fa-pied-piper", "fa fa-pied-piper-alt", "fa fa-pinterest", "fa fa-pinterest-p", "fa fa-pinterest-square", "fa fa-plane", "fa fa-play", "fa fa-play-circle", "fa fa-play-circle-o", "fa fa-plug", "fa fa-plus", "fa fa-plus-circle", "fa fa-plus-square", "fa fa-plus-square-o", "fa fa-power-off", "fa fa-print", "fa fa-puzzle-piece", "fa fa-qq", "fa fa-qrcode", "fa fa-question", "fa fa-question-circle", "fa fa-quote-left", "fa fa-quote-right", "fa fa-ra", "fa fa-random", "fa fa-rebel", "fa fa-recycle", "fa fa-reddit", "fa fa-reddit-square", "fa fa-refresh", "fa fa-registered", "fa fa-remove", "fa fa-renren", "fa fa-reorder", "fa fa-repeat", "fa fa-reply", "fa fa-reply-all", "fa fa-retweet", "fa fa-rmb", "fa fa-road", "fa fa-rocket", "fa fa-rotate-left", "fa fa-rotate-right", "fa fa-rouble", "fa fa-rss", "fa fa-rss-square", "fa fa-rub", "fa fa-ruble", "fa fa-rupee", "fa fa-safari", "fa fa-save", "fa fa-scissors", "fa fa-search", "fa fa-search-minus", "fa fa-search-plus", "fa fa-sellsy", "fa fa-send", "fa fa-send-o", "fa fa-server", "fa fa-share", "fa fa-share-alt", "fa fa-share-alt-square", "fa fa-share-square", "fa fa-share-square-o", "fa fa-shekel", "fa fa-sheqel", "fa fa-shield", "fa fa-ship", "fa fa-shirtsinbulk", "fa fa-shopping-cart", "fa fa-sign-in", "fa fa-sign-out", "fa fa-signal", "fa fa-simplybuilt", "fa fa-sitemap", "fa fa-skyatlas", "fa fa-skype", "fa fa-slack", "fa fa-sliders", "fa fa-slideshare", "fa fa-smile-o", "fa fa-soccer-ball-o", "fa fa-sort", "fa fa-sort-alpha-asc", "fa fa-sort-alpha-desc", "fa fa-sort-amount-asc", "fa fa-sort-amount-desc", "fa fa-sort-asc", "fa fa-sort-desc", "fa fa-sort-down", "fa fa-sort-numeric-asc", "fa fa-sort-numeric-desc", "fa fa-sort-up", "fa fa-soundcloud", "fa fa-space-shuttle", "fa fa-spinner", "fa fa-spoon", "fa fa-spotify", "fa fa-square", "fa fa-square-o", "fa fa-stack-exchange", "fa fa-stack-overflow", "fa fa-star", "fa fa-star-half", "fa fa-star-half-empty", "fa fa-star-half-full", "fa fa-star-half-o", "fa fa-star-o", "fa fa-steam", "fa fa-steam-square", "fa fa-step-backward", "fa fa-step-forward", "fa fa-stethoscope", "fa fa-sticky-note", "fa fa-sticky-note-o", "fa fa-stop", "fa fa-street-view", "fa fa-strikethrough", "fa fa-stumbleupon", "fa fa-stumbleupon-circle", "fa fa-subscript", "fa fa-subway", "fa fa-suitcase", "fa fa-sun-o", "fa fa-superscript", "fa fa-support", "fa fa-table", "fa fa-tablet", "fa fa-tachometer", "fa fa-tag", "fa fa-tags", "fa fa-tasks", "fa fa-taxi", "fa fa-television", "fa fa-tencent-weibo", "fa fa-terminal", "fa fa-text-height", "fa fa-text-width", "fa fa-th", "fa fa-th-large", "fa fa-th-list", "fa fa-thumb-tack", "fa fa-thumbs-down", "fa fa-thumbs-o-down", "fa fa-thumbs-o-up", "fa fa-thumbs-up", "fa fa-ticket", "fa fa-times", "fa fa-times-circle", "fa fa-times-circle-o", "fa fa-tint", "fa fa-toggle-down", "fa fa-toggle-left", "fa fa-toggle-off", "fa fa-toggle-on", "fa fa-toggle-right", "fa fa-toggle-up", "fa fa-trademark", "fa fa-train", "fa fa-transgender", "fa fa-transgender-alt", "fa fa-trash", "fa fa-trash-o", "fa fa-tree", "fa fa-trello", "fa fa-tripadvisor", "fa fa-trophy", "fa fa-truck", "fa fa-try", "fa fa-tty", "fa fa-tumblr", "fa fa-tumblr-square", "fa fa-turkish-lira", "fa fa-tv", "fa fa-twitch", "fa fa-twitter", "fa fa-twitter-square", "fa fa-umbrella", "fa fa-underline", "fa fa-undo", "fa fa-university", "fa fa-unlink", "fa fa-unlock", "fa fa-unlock-alt", "fa fa-unsorted", "fa fa-upload", "fa fa-usd", "fa fa-user", "fa fa-user-md", "fa fa-user-plus", "fa fa-user-secret", "fa fa-user-times", "fa fa-users", "fa fa-venus", "fa fa-venus-double", "fa fa-venus-mars", "fa fa-viacoin", "fa fa-video-camera", "fa fa-vimeo", "fa fa-vimeo-square", "fa fa-vine", "fa fa-vk", "fa fa-volume-down", "fa fa-volume-off", "fa fa-volume-up", "fa fa-warning", "fa fa-wechat", "fa fa-weibo", "fa fa-weixin", "fa fa-whatsapp", "fa fa-wheelchair", "fa fa-wifi", "fa fa-wikipedia-w", "fa fa-windows", "fa fa-won", "fa fa-wordpress", "fa fa-wrench", "fa fa-xing", "fa fa-xing-square", "fa fa-y-combinator", "fa fa-y-combinator-square", "fa fa-yahoo", "fa fa-yc", "fa fa-yc-square", "fa fa-yelp", "fa fa-yen", "fa fa-youtube", "fa fa-youtube-play", "fa fa-youtube-square")

}
