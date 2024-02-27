const ERROR_MESSAGE = "Something went wrong";

const resultElement = document.querySelector("#result");

const updateResult = (message, valid) => {
    resultElement.innerHTML = message;
    resultElement.style.color = valid ? "green" : "red";
}

const makeRequest = async () => {
    try {
        const bsn = document.querySelector("#bsn").value;

        const response = await fetch(`http://localhost:8080/v1/bsn/validate`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                bsn
            })
        });

        const data = await response.json();
        if (!response.ok) {
            updateResult(data?.message || ERROR_MESSAGE, false)
            return;
        }

        const {valid} = data;
        updateResult(valid ? "BSN is valid!" : "BSN is not valid!", valid)
    } catch (e) {
        console.error(e);
        resultElement.innerHTML = ERROR_MESSAGE;
    }
}

document.querySelector("form").addEventListener("submit", async (e) => {
    e.preventDefault();
    await makeRequest();
})