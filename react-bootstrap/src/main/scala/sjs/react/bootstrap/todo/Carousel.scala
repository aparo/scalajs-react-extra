//
//package facades.bootstrap.todo
//
//import facades.bootstrap.BoostrapMixinProps
//import japgolly.scalajs.react._
//
//import scala.scalajs.js
//
//
//
//object Carousel /* mixins: BootstrapMixin*/{
//
//  case class State()
//
//  class Backend(t: BackendScope[Props, State]) {
//  }
//
//  val component = ReactComponentB[Props]("Carousel")
//    .initialState(State())
//    .backend(new Backend(_))
//    .render((P, C, S, B) => {
//    /*
//    function() {
//      var classes = {carousel: true, slide: P.slide}
//      return (React.createElement("div", React.__spread(Map(), P, {className: joinClasses(P.className, classSet(classes)), onMouseOver: this.handleMouseOver, onMouseOut: this.handleMouseOut}), P.indicators ? this.renderIndicators() : null, React.createElement("div", {className: "carousel-inner", ref: "inner"}, ValidComponentChildren.map(C, this.renderItem)), P.controls ? this.renderControls() : null))
//    }
//*/
//  }
//    )
//    .build
//    /*
//  def handleMouseOver(
//    function() {
//      if (P.pauseOnHover)
//      {
//        this.pause()
//      }
//    }
//  )
//*/
///*
//  def waitForNext(
//    function() {
//      if (!this.isPaused && P.slide && P.interval && P.activeIndex == null)
//      {
//        this.timeout = setTimeout(this.next, P.interval)
//      }
//    }
//  )
//*/
///*
//  def componentDidMount(
//    function() {
//      this.waitForNext()
//    }
//  )
//*/
///*
//  def componentWillReceiveProps(
//    function(nextProps) {
//      var activeIndex = this.getActiveIndex()
//      if (nextProps.activeIndex != null && nextProps.activeIndex !== activeIndex)
//      {
//        clearTimeout(this.timeout)
//        this.setState({previousActiveIndex: activeIndex, direction: nextProps.direction != null ? nextProps.direction : this.getDirection(activeIndex, nextProps.activeIndex)})
//      }
//    }
//  )
//*/
///*
//  def getInitialState(
//    function() {
//      return {activeIndex: P.defaultActiveIndex == null ? 0 : P.defaultActiveIndex, previousActiveIndex: null, direction: null}
//    }
//  )
//*/
///*
//  def play(
//    function() {
//      this.isPaused = false
//      this.waitForNext()
//    }
//  )
//*/
///*
//  def getActiveIndex(
//    function() {
//      return P.activeIndex != null ? P.activeIndex : this.state.activeIndex
//    }
//  )
//*/
///*
//  def getDirection(
//    function(prevIndex, index) {
//      if (prevIndex === index)
//      {
//        return null
//      }
//      return prevIndex > index ? "prev" : "next"
//    }
//  )
//*/
///*
//  def pause(
//    function() {
//      this.isPaused = true
//      clearTimeout(this.timeout)
//    }
//  )
//*/
///*
//  def prev(
//    function(e) {
//      if (e)
//      {
//        e.preventDefault()
//      }
//      var index = this.getActiveIndex() - 1
//      if (index < 0)
//      {
//        if (!P.wrap)
//        {
//          return
//        }
//        index = ValidComponentChildren.numberOf(C) - 1
//      }
//      this.handleSelect(index, "prev")
//    }
//  )
//*/
///*
//  def renderPrev(
//    function() {
//      return (React.createElement("a", {className: "left carousel-control", href: "#prev", key: 0, onClick: this.prev}, React.createElement("span", {className: "glyphicon glyphicon-chevron-left"})))
//    }
//  )
//*/
///*
//  def handleMouseOut(
//    function() {
//      if (this.isPaused)
//      {
//        this.play()
//      }
//    }
//  )
//*/
///*
//  def renderIndicators(
//    function() {
//      var indicators = []
//      ValidComponentChildren.forEach(C, function(child, index) {
//  indicators.push(this.renderIndicator(child, index), " ")
//}, this)
//      return (React.createElement("ol", {className: "carousel-indicators"}, indicators))
//    }
//  )
//*/
///*
//  def renderControls(
//    function() {
//      if (P.wrap)
//      {
//        var activeIndex = this.getActiveIndex()
//        var count = ValidComponentChildren.numberOf(C)
//        return [(activeIndex !== 0) ? this.renderPrev() : null, (activeIndex !== count - 1) ? this.renderNext() : null]
//      }
//      return [this.renderPrev(), this.renderNext()]
//    }
//  )
//*/
///*
//  def next(
//    function(e) {
//      if (e)
//      {
//        e.preventDefault()
//      }
//      var index = this.getActiveIndex() + 1
//      var count = ValidComponentChildren.numberOf(C)
//      if (index > count - 1)
//      {
//        if (!P.wrap)
//        {
//          return
//        }
//        index = 0
//      }
//      this.handleSelect(index, "next")
//    }
//  )
//*/
///*
//  def handleItemAnimateOutEnd(
//    function() {
//      this.setState({previousActiveIndex: null, direction: null}, function() {
//  this.waitForNext()
//  if (P.onSlideEnd)
//  {
//    P.onSlideEnd()
//  }
//})
//    }
//  )
//*/
///*
//  def renderNext(
//    function() {
//      return (React.createElement("a", {className: "right carousel-control", href: "#next", key: 1, onClick: this.next}, React.createElement("span", {className: "glyphicon glyphicon-chevron-right"})))
//    }
//  )
//*/
///*
//  def renderIndicator(
//    function(child, index) {
//      var className = (index === this.getActiveIndex()) ? "active" : null
//      return (React.createElement("li", {key: index, className: className, onClick: this.handleSelect.bind(this, index, null)}))
//    }
//  )
//*/
///*
//  def componentWillUnmount(
//    function() {
//      clearTimeout(this.timeout)
//    }
//  )
//*/
///*
//  def renderItem(
//    function(child, index) {
//      var activeIndex = this.getActiveIndex()
//      var isActive = (index === activeIndex)
//      var isPreviousActive = this.state.previousActiveIndex != null && this.state.previousActiveIndex === index && P.slide
//      return cloneWithProps(child, {active: isActive, ref: child.ref, key: child.key ? child.key : index, index: index, animateOut: isPreviousActive, animateIn: isActive && this.state.previousActiveIndex != null && P.slide, direction: this.state.direction, onAnimateOutEnd: isPreviousActive ? this.handleItemAnimateOutEnd : null})
//    }
//  )
//*/
///*
//  def handleSelect(
//    function(index, direction) {
//      clearTimeout(this.timeout)
//      var previousActiveIndex = this.getActiveIndex()
//      direction = direction || this.getDirection(previousActiveIndex, index)
//      if (P.onSelect)
//      {
//        P.onSelect(index, direction)
//      }
//      if (P.activeIndex == null && index !== previousActiveIndex)
//      {
//        if (this.state.previousActiveIndex != null)
//        {
//          return
//        }
//        this.setState({activeIndex: index, previousActiveIndex: previousActiveIndex, direction: direction})
//      }
//    }
//  )
//*/case class Props(direction:String, activeIndex:Int=0, bsClass:String="",
//  bsSize:String="", bsStyle:String="", controls:Boolean=true,
//  defaultActiveIndex:Int=0, indicators:Boolean=true, interval:Int=5000,
//  onSelect:(ReactEventI) => Unit=null, onSlideEnd:(ReactEventI) => Unit=null, pauseOnHover:Boolean=true,
//  slide:Boolean=true, wrap:Boolean=true) extends BoostrapMixinProps
//def apply(direction:String, activeIndex:Int=0, bsClass:String="",
//  bsSize:String="", bsStyle:String="", controls:Boolean=true,
//  defaultActiveIndex:Int=0, indicators:Boolean=true, interval:Int=5000,
//  onSelect:(ReactEventI) => Unit=null, onSlideEnd:(ReactEventI) => Unit=null, pauseOnHover:Boolean=true,
//  slide:Boolean=true, wrap:Boolean=true, ref: js.UndefOr[String] = "",
//  key: js.Any = {})(children: ReactNode*)= {
//   component.set(key, ref)(Props(direction = direction, activeIndex = activeIndex, bsClass = bsClass,
//  bsSize = bsSize, bsStyle = bsStyle, controls = controls,
//  defaultActiveIndex = defaultActiveIndex, indicators = indicators, interval = interval,
//  onSelect = onSelect, onSlideEnd = onSlideEnd, pauseOnHover = pauseOnHover,
//  slide = slide, wrap = wrap),children)
//}
//
//}
