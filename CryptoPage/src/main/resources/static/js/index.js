 document.addEventListener("scroll", function() {
    let scrollTop = window.scrollY;
    let firstSection = document.getElementById("first");
    firstSection.style.transform = `translateY(${scrollTop * 0.5}px)`;
});