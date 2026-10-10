// Configuration
const CONFIG = {
    // This is the backend API URL. For deployment, change this to the actual Java backend URL.
    // For local development with Tomcat maven plugin, it usually runs on http://localhost:8081/api/feedback
    API_URL: 'http://localhost:8081/api/feedback'
};

async function submitFeedback(event) {
    event.preventDefault();
    
    const form = event.target;
    const submitBtn = document.getElementById('submitBtn');
    const btnText = submitBtn.querySelector('.btn-text');
    const btnLoader = submitBtn.querySelector('.btn-loader');
    const errorBanner = document.getElementById('error-message');
    
    // Clear previous errors
    errorBanner.classList.add('hidden');
    errorBanner.textContent = '';
    
    // Collect data
    const formData = new FormData(form);
    const data = {
        eventName: formData.get('eventName'),
        name: formData.get('name') || null,
        email: formData.get('email') || null,
        department: formData.get('department'),
        year: formData.get('year'),
        overallRating: parseInt(formData.get('overallRating')),
        contentRating: parseInt(formData.get('contentRating')),
        organizationRating: parseInt(formData.get('organizationRating')),
        venueRating: parseInt(formData.get('venueRating')),
        recommendation: formData.get('recommendation'),
        comments: formData.get('comments') || null
    };

    // UI Loading state
    submitBtn.disabled = true;
    btnText.classList.add('hidden');
    btnLoader.classList.remove('hidden');

    try {
        const response = await fetch(CONFIG.API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify(data)
        });

        const result = await response.json().catch(() => ({}));

        if (!response.ok) {
            throw new Error(result.error || 'Failed to submit feedback. Please try again.');
        }

        // Show success state
        form.classList.add('hidden');
        document.getElementById('success-message').classList.remove('hidden');
        
    } catch (error) {
        // Show error message
        errorBanner.textContent = error.message || 'A network error occurred. Is the backend running?';
        errorBanner.classList.remove('hidden');
    } finally {
        // Restore button state
        submitBtn.disabled = false;
        btnText.classList.remove('hidden');
        btnLoader.classList.add('hidden');
    }
}

function resetForm() {
    const form = document.getElementById('feedback-form');
    form.reset();
    
    // Uncheck radio buttons manually (for the stars)
    const radios = form.querySelectorAll('input[type="radio"]');
    radios.forEach(r => r.checked = false);

    form.classList.remove('hidden');
    document.getElementById('success-message').classList.add('hidden');
    document.getElementById('error-message').classList.add('hidden');
    
    window.scrollTo({ top: 0, behavior: 'smooth' });
}
