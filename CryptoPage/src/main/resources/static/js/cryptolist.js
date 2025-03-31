document.addEventListener("DOMContentLoaded", function () {
    fetch('/api/crypto/prices')
        .then(response => response.json())
        .then(data => {
            let list = document.getElementById('crypto-list');
            list.innerHTML = "";
            data.forEach(crypto => {
                let li = document.createElement('li');
                li.textContent = `${crypto.name}: ${crypto.quote.USD.price.toFixed(2)} USD`;
                list.appendChild(li);
            });
        })
        .catch(error => console.error('GETTING DATA ERROR:', error));
});
