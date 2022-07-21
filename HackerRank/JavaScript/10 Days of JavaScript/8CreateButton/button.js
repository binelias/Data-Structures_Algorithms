// Task

// Complete the code in the editor so that it creates a clickable button satisfying the following properties:

// The button's id is btn.
// The button's initial text label is . After each click, the button must increment by . Recall that the button's text label is the JS object's innerHTML property.
// The button has the following style properties:
// A width of 96px.
// A height of 48px.
// The font-size attribute is 24px.
// The .js and .css files are in different directories, so use the link tag to provide the CSS file path and the script tag to provide the JS file path:

document.addEventListener('DOMContentLoaded', () => {
  const button = document.getElementById('btn');
  button.addEventListener('click', (e) => {
        const count = Number(e.currentTarget.innerText) + 1;
        e.currentTarget.innerText = count;
  });
});