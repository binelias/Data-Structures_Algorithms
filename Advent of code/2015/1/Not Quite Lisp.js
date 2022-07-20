const fs = require('fs')

//1 - what floor does Santa end upon
// ( - up 1 floor
// ) - down 1 floor

function question1 () {
    fs.readFile('./santa.txt', (err, data) => {
        console.time('Q1 santa-time');
        const directions = data.toString();
        const directionsArray = directions.split('');
        const answer = directionsArray.reduce((acc,currentValue) => {
            if (currentValue === '(') {
                return acc += 1
            } else if (currentValue === ')'){
                return acc -= 1
            }
        }, 0)
        console.timeEnd('Q1 santa-time');
        console.log('Current floor:',answer) //74 floors
    })
}

question1()

//2 - When does Santa first enter the basement

function question2 () {
    fs.readFile('./santa.txt', (err, data) => {
        console.time('Q2 santa-time');
        const directions = data.toString();
        const directionsArray = directions.split('');
        let accumulator = 0;
        let counter = 0;
        const answer = directionsArray.some((currentItem) => {
            if (currentItem === '(') {
                accumulator += 1
            } else if (currentItem === ')'){
                accumulator -= 1
            } 
            counter ++
            return accumulator < 0;
        })
        console.timeEnd('Q2 santa-time');
        console.log('Basement at:',counter) //1795 floors
    })
}

question2()