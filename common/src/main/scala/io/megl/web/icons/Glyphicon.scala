/*
 * Copyright (c) 2016 - Alberto Paro All Rights Reserved.
 */

package io.megl.web.icons

import japgolly.scalajs.react.vdom.all._

/**
  * Provides type-safe access to Glyphicon icons
  */

object Glyphicon {
  def apply(name: String): web.Icon = i(cls := s"glyphicon-$name")

  def adjust = apply("adjust")

  def alert = apply("alert")

  def alignCenter = apply("align-center")

  def alignJustify = apply("align-justify")

  def alignLeft = apply("align-left")

  def alignRight = apply("align-right")

  def apple = apply("apple")

  def arrowDown = apply("arrow-down")

  def arrowLeft = apply("arrow-left")

  def arrowRight = apply("arrow-right")

  def arrowUp = apply("arrow-up")

  def asterisk = apply("asterisk")

  def babyFormula = apply("baby-formula")

  def backward = apply("backward")

  def banCircle = apply("ban-circle")

  def barcode = apply("barcode")

  def bed = apply("bed")

  def bell = apply("bell")

  def bishop = apply("bishop")

  def bitcoin = apply("bitcoin")

  def blackboard = apply("blackboard")

  def bold = apply("bold")

  def book = apply("book")

  def bookmark = apply("bookmark")

  def briefcase = apply("briefcase")

  def btc = apply("btc")

  def bullhorn = apply("bullhorn")

  def calendar = apply("calendar")

  def camera = apply("camera")

  def cd = apply("cd")

  def certificate = apply("certificate")

  def check = apply("check")

  def chevronDown = apply("chevron-down")

  def chevronLeft = apply("chevron-left")

  def chevronRight = apply("chevron-right")

  def chevronUp = apply("chevron-up")

  def circleArrowDown = apply("circle-arrow-down")

  def circleArrowLeft = apply("circle-arrow-left")

  def circleArrowRight = apply("circle-arrow-right")

  def circleArrowUp = apply("circle-arrow-up")

  def cloud = apply("cloud")

  def cloudDownload = apply("cloud-download")

  def cloudUpload = apply("cloud-upload")

  def cog = apply("cog")

  def collapseDown = apply("collapse-down")

  def collapseUp = apply("collapse-up")

  def comment = apply("comment")

  def compressed = apply("compressed")

  def console = apply("console")

  def copy = apply("copy")

  def copyrightMark = apply("copyright-mark")

  def creditCard = apply("credit-card")

  def cutlery = apply("cutlery")

  def dashboard = apply("dashboard")

  def door = apply("door")

  def download = apply("download")

  def downloadAlt = apply("download-alt")

  def duplicate = apply("duplicate")

  def earphone = apply("earphone")

  def edit = apply("edit")

  def education = apply("education")

  def eject = apply("eject")

  def envelope = apply("envelope")

  def equalizer = apply("equalizer")

  def erase = apply("erase")

  def eur = apply("eur")

  def euro = apply("euro")

  def exclamationSign = apply("exclamation-sign")

  def expand = apply("expand")

  def export = apply("export")

  def eyeClose = apply("eye-close")

  def eyeOpen = apply("eye-open")

  def facetimeVideo = apply("facetime-video")

  def fastBackward = apply("fast-backward")

  def fastForward = apply("fast-forward")

  def file = apply("file")

  def film = apply("film")

  def filter = apply("filter")

  def fire = apply("fire")

  def flag = apply("flag")

  def flash = apply("flash")

  def floppyDisk = apply("floppy-disk")

  def floppyOpen = apply("floppy-open")

  def floppyRemove = apply("floppy-remove")

  def floppySave = apply("floppy-save")

  def floppySaved = apply("floppy-saved")

  def folderClose = apply("folder-close")

  def folderOpen = apply("folder-open")

  def font = apply("font")

  def forward = apply("forward")

  def fullscreen = apply("fullscreen")

  def gbp = apply("gbp")

  def gift = apply("gift")

  def glass = apply("glass")

  def globe = apply("globe")

  def grain = apply("grain")

  def handDown = apply("hand-down")

  def handLeft = apply("hand-left")

  def handRight = apply("hand-right")

  def handUp = apply("hand-up")

  def hdVideo = apply("hd-video")

  def hdd = apply("hdd")

  def header = apply("header")

  def headphones = apply("headphones")

  def heart = apply("heart")

  def heartEmpty = apply("heart-empty")

  def home = apply("home")

  def hourglass = apply("hourglass")

  def iceLolly = apply("ice-lolly")

  def iceLollyTasted = apply("ice-lolly-tasted")

  def imporT = apply("import")

  def inbox = apply("inbox")

  def indentLeft = apply("indent-left")

  def indentRight = apply("indent-right")

  def infoSign = apply("info-sign")

  def italic = apply("italic")

  def jpy = apply("jpy")

  def key = apply("key")

  def king = apply("king")

  def knight = apply("knight")

  def lamp = apply("lamp")

  def leaf = apply("leaf")

  def levelUp = apply("level-up")

  def link = apply("link")

  def list = apply("list")

  def listAlt = apply("list-alt")

  def lock = apply("lock")

  def logIn = apply("log-in")

  def logOut = apply("log-out")

  def magnet = apply("magnet")

  def mapMarker = apply("map-marker")

  def menuDown = apply("menu-down")

  def menuHamburger = apply("menu-hamburger")

  def menuLeft = apply("menu-left")

  def menuRight = apply("menu-right")

  def menuUp = apply("menu-up")

  def minus = apply("minus")

  def minusSign = apply("minus-sign")

  def modalWindow = apply("modal-window")

  def move = apply("move")

  def music = apply("music")

  def newWindow = apply("new-window")

  def objectAlignBottom = apply("object-align-bottom")

  def objectAlignHorizontal = apply("object-align-horizontal")

  def objectAlignLeft = apply("object-align-left")

  def objectAlignRight = apply("object-align-right")

  def objectAlignTop = apply("object-align-top")

  def objectAlignVertical = apply("object-align-vertical")

  def off = apply("off")

  def oil = apply("oil")

  def ok = apply("ok")

  def okCircle = apply("ok-circle")

  def okSign = apply("ok-sign")

  def open = apply("open")

  def openFile = apply("open-file")

  def optionHorizontal = apply("option-horizontal")

  def optionVertical = apply("option-vertical")

  def paperclip = apply("paperclip")

  def paste = apply("paste")

  def pause = apply("pause")

  def pawn = apply("pawn")

  def pencil = apply("pencil")

  def phone = apply("phone")

  def phoneAlt = apply("phone-alt")

  def picture = apply("picture")

  def piggyBank = apply("piggy-bank")

  def plane = apply("plane")

  def play = apply("play")

  def playCircle = apply("play-circle")

  def plus = apply("plus")

  def plusSign = apply("plus-sign")

  def print = apply("print")

  def pushpin = apply("pushpin")

  def qrcode = apply("qrcode")

  def queen = apply("queen")

  def questionSign = apply("question-sign")

  def random = apply("random")

  def record = apply("record")

  def refresh = apply("refresh")

  def registrationMark = apply("registration-mark")

  def remove = apply("remove")

  def removeCircle = apply("remove-circle")

  def removeSign = apply("remove-sign")

  def repeat = apply("repeat")

  def resizeFull = apply("resize-full")

  def resizeHorizontal = apply("resize-horizontal")

  def resizeSmall = apply("resize-small")

  def resizeVertical = apply("resize-vertical")

  def retweet = apply("retweet")

  def road = apply("road")

  def rub = apply("rub")

  def ruble = apply("ruble")

  def save = apply("save")

  def saveFile = apply("save-file")

  def saved = apply("saved")

  def scale = apply("scale")

  def scissors = apply("scissors")

  def screenshot = apply("screenshot")

  def sdVideo = apply("sd-video")

  def search = apply("search")

  def send = apply("send")

  def share = apply("share")

  def shareAlt = apply("share-alt")

  def shoppingCart = apply("shopping-cart")

  def signal = apply("signal")

  def sort = apply("sort")

  def sortByAlphabet = apply("sort-by-alphabet")

  def sortByAlphabetAlt = apply("sort-by-alphabet-alt")

  def sortByAttributes = apply("sort-by-attributes")

  def sortByAttributesAlt = apply("sort-by-attributes-alt")

  def sortByOrder = apply("sort-by-order")

  def sortByOrderAlt = apply("sort-by-order-alt")

  def sound51 = apply("sound-5-1")

  def sound61 = apply("sound-6-1")

  def sound71 = apply("sound-7-1")

  def soundDolby = apply("sound-dolby")

  def soundStereo = apply("sound-stereo")

  def star = apply("star")

  def starEmpty = apply("star-empty")

  def stats = apply("stats")

  def stepBackward = apply("step-backward")

  def stepForward = apply("step-forward")

  def stop = apply("stop")

  def subscript = apply("subscript")

  def subtitles = apply("subtitles")

  def sunglasses = apply("sunglasses")

  def superscript = apply("superscript")

  def tag = apply("tag")

  def tags = apply("tags")

  def tasks = apply("tasks")

  def tent = apply("tent")

  def textBackground = apply("text-background")

  def textColor = apply("text-color")

  def textHeight = apply("text-height")

  def textSize = apply("text-size")

  def textWidth = apply("text-width")

  def th = apply("th")

  def thLarge = apply("th-large")

  def thList = apply("th-list")

  def thumbsDown = apply("thumbs-down")

  def thumbsUp = apply("thumbs-up")

  def time = apply("time")

  def tint = apply("tint")

  def tower = apply("tower")

  def transfer = apply("transfer")

  def trash = apply("trash")

  def treeConifer = apply("tree-conifer")

  def treeDeciduous = apply("tree-deciduous")

  def triangleBottom = apply("triangle-bottom")

  def triangleLeft = apply("triangle-left")

  def triangleRight = apply("triangle-right")

  def triangleTop = apply("triangle-top")

  def unchecked = apply("unchecked")

  def upload = apply("upload")

  def usd = apply("usd")

  def user = apply("user")

  def volumeDown = apply("volume-down")

  def volumeOff = apply("volume-off")

  def volumeUp = apply("volume-up")

  def warningSign = apply("warning-sign")

  def wrench = apply("wrench")

  def xbt = apply("xbt")

  def yen = apply("yen")

  def zoomIn = apply("zoom-in")

  def zoomOut = apply("zoom-out")

}
