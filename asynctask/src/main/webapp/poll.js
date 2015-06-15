function AsyncTask(){
	console.log('AsyncTasl initialized');
	this.intervalId = null;
	this.details = null;


//var intervalId, details;
	this.getComments = function(){
		var status = '';
		console.log('Get in getComments '+this.details);
		if(this.details === null) {
			$.ajax(
				{
					url:'/ProcessDataRequests',
					data:'getData',
					success: function(data) {
						console.log(data);
						if(data.data.indexOf('Still processing') > -1){
							status = 'setup polling';		
						}else if(data.Comments)
						{		
							console.log('Got the data back '+data.Comments);
							this.details = data;
							$('#name').html(data.Comments.name);
							$('#email').html(data.Comments.email);
							$('#body').html(data.Comments.body);

							status= 'true';
						}
					},
					error: function(error) {
						consolse.error(error);
						status= 'error';
					}	
				}
			);
		}
		return status;
	};
this.getData =	function(){
					var self = this;
					console.log('Calling get data');
					var status = self.getComments();
					if(status.indexOf('true') > -1)
					{
						clearInterval(intervalId);
						console.log('Interval cleared with Id '+intervalId);							
					}else if((status.indexOf('setup polling') > -1) && (intervalId == null))
					{
						
						this.intervalId = setInterval(getComments,3000);
						console.log('Interval setup with Id '+intervalId);
						$("#btn").disabled='disabled';
						
					}else if((status.indexOf('setup polling') > -1) && (intervalId !== null)){
						console.log('Keep polling '+this.intervalId);
					}else if(status.indexOf('error'> -1)){
						clearInterval(intervalId);	 
						console.error('Error occurred');
					}

			};

			
}