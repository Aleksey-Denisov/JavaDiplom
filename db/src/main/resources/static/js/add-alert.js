function addAlerts(id, idAlerts) {
    const value_alerts = document.getElementById(id).value;
    const value_alerts_array = document.getElementById(idAlerts).value;
    if(value_alerts > value_alerts_array)
    {
        let i = value_alerts_array;
        while(i < value_alerts) {
            const myDiv = document.getElementById("alert__div" + (i - 1));
            const divClone = myDiv.cloneNode(true);
            divClone.removeAttribute("id");
            divClone.setAttribute("id", "alert__div" + i);
            idC(divClone, i);
            myDiv.parentNode.insertBefore(divClone, myDiv.nextSibling);
            i++;
        }
        document.getElementById(idAlerts).setAttribute("value", value_alerts);
    }
    if(value_alerts < value_alerts_array)
    {
        let i = value_alerts_array - 1;
        while(i >= value_alerts) {
            const elem = document.getElementById("alert__div" + i);
            elem.parentNode.removeChild(elem);
            i--;
        }
        document.getElementById(idAlerts).setAttribute("value", value_alerts);
    }
}

function idC(elm, ind) {
    if (elm.matches('[id]')) {
        elm.id = elm.id.replace("alerts" + (ind - 1), "alerts" + ind);
    }
    if (elm.matches('[name]')) {
        elm.name = elm.name.replace((ind - 1), ind);
    }
    for (let i = 0; i < elm.childElementCount; i++) {
        idC(elm.children[i], ind);
    }
}
