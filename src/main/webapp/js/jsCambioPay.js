// selezionare gli elementi della navbar
const creditTab = document.querySelector('#creditsCard');
const debitTab = document.querySelector('#debitCard');

// selezionare gli elementi del form
const creditForm = document.querySelector('#creditForm');
const debitForm = document.querySelector('#debitForm');

// aggiungere un evento di click alla scheda di credito
creditTab.addEventListener('click', () => {
    creditTab.classList.toggle('active');
    debitTab.classList.toggle('active');
    creditForm.style.display = 'block';
    debitForm.style.display = 'none';
});

// aggiungere un evento di click alla scheda di debito
debitTab.addEventListener('click', () => {
    debitTab.classList.toggle('active');
    creditTab.classList.toggle('active');
    debitForm.style.display = 'block';
    creditForm.style.display = 'none';
});


//2
const navLinks = document.querySelectorAll('.nav-link');
const navIndicator = document.querySelector('.nav-indicator');

navLinks.forEach(link => {
    link.addEventListener('click', (e) => {
        e.preventDefault();
        navLinks.forEach(link => link.classList.remove('active'));
        e.target.classList.add('active');
        const linkWidth = e.target.offsetWidth;
        const linkLeft = e.target.offsetLeft;
        navIndicator.style.width = `${linkWidth}px`;
        navIndicator.style.transform = `translateX(${linkLeft}px)`;
    });
});