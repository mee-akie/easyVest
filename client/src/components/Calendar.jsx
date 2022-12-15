import React, {Component} from 'react';
import {DayPilot, DayPilotCalendar, DayPilotNavigator} from "@daypilot/daypilot-lite-react";
import { deleteEvent, postAddEvent, putUpdateEvent } from '../services/api';

const styles = {
  wrap: {
    display: "flex"
  },
  left: {
    marginRight: "10px"
  },
  main: {
    flexGrow: "1"
  }
};

class Calendar extends Component {

  constructor(props) {
    super(props);
    this.calendarRef = React.createRef();
    this.state = {
      viewType: "Week",
      durationBarVisible: true,
      timeRangeSelectedHandling: "Enabled",
      onTimeRangeSelected: async args => {
        const dp = this.calendar;
        const modal = await DayPilot.Modal.prompt("Create a new event:", "Event 1");
        dp.clearSelection();
        if (!modal.result) { return; }
        try{
          const userLogged = JSON.parse(localStorage.getItem('u'))
          const addResponse = await postAddEvent(modal.result, args.start.value.replace('T', ' '), args.end.value.replace('T', ' '), userLogged.id, userLogged.premium, userLogged.nome, userLogged.senha, userLogged.login )
          
          dp.events.add({
          start: addResponse.data.registro_inicio,
          end: addResponse.data.registro_fim,
          id: addResponse.data.registro_id,
          text: addResponse.data.registro_nome
        });
        }catch(err){

        }
      },
      eventDeleteHandling: "Update",
      onEventDelete: async args => {
        const e = args.e
        const userLogged = JSON.parse(localStorage.getItem('u'))
        await deleteEvent(e.data.id, e.data.text, e.data.start.value.replace('T', ' '), e.data.end.value.replace('T', ' '), userLogged.id, userLogged.premium, userLogged.nome, userLogged.senha, userLogged.login)
        console.log(args)
      },
      onEventClick: async args => {
        const dp = this.calendar;
        const modal = await DayPilot.Modal.prompt("Update event text:", args.e.text());
        if (!modal.result) { return; }
        const e = args.e;
        e.data.text = modal.result;

        const userLogged = JSON.parse(localStorage.getItem('u'))
        await putUpdateEvent(e.data.id, e.data.text, e.data.start.value.replace('T', ' '), e.data.end.value.replace('T', ' '), userLogged.id, userLogged.premium, userLogged.nome, userLogged.senha, userLogged.login)

        dp.events.update(e);
      },
      events: props.events,
    };
  }

  get calendar() {
    return this.calendarRef.current.control;
  }

  componentDidMount() {

    const events = this.state.events;
    
    const startDate = Date.now();

    this.calendar.update({startDate, events});

  }

  componentWillReceiveProps(nextProps) {
    this.state.events = nextProps.events;
  }

  render() {
    return (
      <div style={styles.wrap}>
        <div style={styles.left}>
          <DayPilotNavigator
            selectMode={"week"}
            showMonths={1}
            skipMonths={1}
            startDate={Date.now()}
            selectionDay={Date.now()}
            onTimeRangeSelected={ args => {
              this.calendar.update({
                startDate: args.day
              });
            }}
          />
        </div>
        <div style={styles.main}>
          <DayPilotCalendar
            {...this.state}
            ref={this.calendarRef}
          />
        </div>
      </div>
    );
  }
}

export default Calendar;