window.addEventListener('load',start)

function start (event) {
    console.log('Hello World')
    const cardsIndexURL = '/api/cards/balances'
    fetch(cardsIndexURL, {
    })
        .then(response => response.json())
        .then(data => appendData(data))
        .catch(exception => console.log(exception))
}

function appendData(cardsData){
    const list = document.querySelector('.cards')
    cardsData
        .map(card => `<tr><th>${card.cardNumber}</th><th>${card.balance}</th></tr>`)
        .forEach(cardHTML => list.insertAdjacentHTML('beforeend',cardHTML))
}